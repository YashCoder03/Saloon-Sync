package com.saas.salonsync.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.saas.salonsync.entity.TokenEntity;

public interface RefreshTokenRepository extends JpaRepository<TokenEntity, UUID> {
    Optional<TokenEntity> findByUserId(UUID userId);
    // If you store multiple tokens per user (per device) you'll search differently:
    Optional<TokenEntity> findByUserIdAndRevokedFalse(UUID userId);
    Optional<TokenEntity> findByIdAndRevokedFalse(UUID userId);
}