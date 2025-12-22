package com.saas.salonsync.service;

import java.security.SecureRandom;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saas.salonsync.entity.TokenEntity;
import com.saas.salonsync.repository.RefreshTokenRepository;



@Service
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final SecureRandom secureRandom = new SecureRandom();
    private final long refreshDays;

    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository,
                               PasswordEncoder passwordEncoder,
                               @Value("${jwt.refresh-days:30}") long refreshDays) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.refreshDays = refreshDays;
    }

    private String genSecret() {
        byte[] b = new byte[32];
        secureRandom.nextBytes(b);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(b);
    }

    @Transactional
    public String createForUser(UUID userId) {
        String secret = genSecret();
        String hash = passwordEncoder.encode(secret);
        Instant now = Instant.now();
        Instant expiry = now.plus(refreshDays, ChronoUnit.DAYS);

        TokenEntity tokenEntity = new TokenEntity(expiry, hash, userId);
        

        TokenEntity savedTokenEntity =  refreshTokenRepository.save(tokenEntity);
        System.out.println("Working till here"); 

        return savedTokenEntity.getId().toString() + "|" + secret;   // cookie value
    }

    @Transactional(readOnly = true)
    public Optional<TokenEntity> validateCookie(String cookieValue) {
        if (cookieValue == null) return Optional.empty();
        String[] parts = cookieValue.split("\\|");
        if (parts.length != 2) return Optional.empty();
        UUID id;
        try { id = UUID.fromString(parts[0]); } catch (IllegalArgumentException e) { return Optional.empty(); }
        String plain = parts[1];

        return refreshTokenRepository.findByIdAndRevokedFalse(id)
                   .filter(t -> t.getExpiryDate().isAfter(Instant.now()))
                   .filter(t -> passwordEncoder.matches(plain, t.getToken()));
    }

    @Transactional
    public String rotate(TokenEntity existing) {
        existing.setRevoked(true);
        refreshTokenRepository.save(existing);
        return createForUser(existing.getUserId());
    }

    @Transactional
    public void revokeByCookie(String cookieValue) {
        validateCookie(cookieValue).ifPresent(t -> { t.setRevoked(true); refreshTokenRepository.save(t); });
    }

    @Transactional
    public void revokeAllForUser(UUID userId) {
        refreshTokenRepository.findAll().stream()
            .filter(t -> !t.isRevoked() && t.getUserId().equals(userId))
            .forEach(t -> { t.setRevoked(true); refreshTokenRepository.save(t); });
    }
}

