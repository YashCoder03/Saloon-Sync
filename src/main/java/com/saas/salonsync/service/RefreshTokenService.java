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

    private final RefreshTokenRepository repo;
    private final PasswordEncoder passwordEncoder;
    private final SecureRandom secureRandom = new SecureRandom();
    private final long refreshDays;

    public RefreshTokenService(RefreshTokenRepository repo,
                               PasswordEncoder passwordEncoder,
                               @Value("${jwt.refresh-days:30}") long refreshDays) {
        this.repo = repo;
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
        UUID id = UUID.randomUUID();
        String secret = genSecret();
        String hash = passwordEncoder.encode(secret);
        Instant now = Instant.now();
        Instant expiry = now.plus(refreshDays, ChronoUnit.DAYS);

        TokenEntity t = new TokenEntity();
        t.setId(id);
        t.setUserId(userId);
        t.setToken(hash);
        t.setCreatedAt(now);
        t.setExpiryDate(expiry);
        repo.save(t);

        return id.toString() + "|" + secret;   // cookie value
    }

    @Transactional(readOnly = true)
    public Optional<TokenEntity> validateCookie(String cookieValue) {
        if (cookieValue == null) return Optional.empty();
        String[] parts = cookieValue.split("\\|");
        if (parts.length != 2) return Optional.empty();
        UUID id;
        try { id = UUID.fromString(parts[0]); } catch (IllegalArgumentException e) { return Optional.empty(); }
        String plain = parts[1];

        return repo.findByIdAndRevokedFalse(id)
                   .filter(t -> t.getExpiryDate().isAfter(Instant.now()))
                   .filter(t -> passwordEncoder.matches(plain, t.getToken()));
    }

    @Transactional
    public String rotate(TokenEntity existing) {
        existing.setRevoked(true);
        repo.save(existing);
        return createForUser(existing.getUserId());
    }

    @Transactional
    public void revokeByCookie(String cookieValue) {
        validateCookie(cookieValue).ifPresent(t -> { t.setRevoked(true); repo.save(t); });
    }

    @Transactional
    public void revokeAllForUser(UUID userId) {
        repo.findAll().stream()
            .filter(t -> !t.isRevoked() && t.getUserId().equals(userId))
            .forEach(t -> { t.setRevoked(true); repo.save(t); });
    }
}

