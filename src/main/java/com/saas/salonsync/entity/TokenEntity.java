package com.saas.salonsync.entity;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TokenEntity {

    @Id
    @Column(unique = true, nullable = false)
    private UUID id = UUID.randomUUID();

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private String token;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt = Instant.now();

    @Column(name = "expiry_date", nullable = false)
    private Instant expiryDate;

    @Column(name = "revoked", nullable = false)
    private boolean revoked = false;

    public TokenEntity(Instant expiryDate, String token, UUID userId) {
        this.expiryDate = expiryDate;
        this.token = token;
        this.userId = userId;
    }
    public TokenEntity() {}

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Instant expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isRevoked() {
        return revoked;
    }

    public void setRevoked(boolean revoked) {
        this.revoked = revoked;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
