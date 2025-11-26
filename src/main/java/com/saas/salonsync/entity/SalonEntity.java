package com.saas.salonsync.entity;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SalonEntity {
    
    @Id
    @Column(unique = true, nullable = false)
    private UUID id = UUID.randomUUID();

    @Column(nullable=false,unique=true)
    private String name;

    @Column(nullable=true)
    private String address;

    @Column(nullable=false)
    private UUID ownerID;

    @Column(nullable=false)
    private Instant createdAt = Instant.now();
    
    public SalonEntity(UUID id, String name, String address, UUID ownerID, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.ownerID = ownerID;
        this.createdAt = createdAt;
    }


    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   

    public SalonEntity(String name, String address, UUID ownerID) {
        this.name = name;
        this.address = address;
        this.ownerID = ownerID;
    }

   

   

    public void setOwnerID(UUID ownerID) {
        this.ownerID = ownerID;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public SalonEntity() {
    }

    public SalonEntity(String name, UUID ownerID) {
        this.name = name;
        this.ownerID = ownerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getownerID() {
        return ownerID;
    }
}
