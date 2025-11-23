package com.saas.salonsync.entity;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TenantEntity {
    
    @Id
    @Column(unique = true, nullable = false)
    private UUID id = UUID.randomUUID();

    @Column(nullable=false,unique=true)
    private String name;

    @Column(nullable=false)
    private UUID userID;

    @Column(nullable=false)
    private Instant createdAt = Instant.now();

    public TenantEntity() {
    }

    public TenantEntity(String name, UUID userID) {
        this.name = name;
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }
}
