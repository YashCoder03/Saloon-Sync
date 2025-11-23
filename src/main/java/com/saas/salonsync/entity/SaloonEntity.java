package com.saas.salonsync.entity;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SaloonEntity {
    
    @Id
    @Column(unique = true, nullable = false)
    private UUID id = UUID.randomUUID();

    @Column(nullable=false,unique=true)
    private String name;

    @Column(nullable=true)
    private String address;

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

    @Column(nullable=false)
    private UUID ownerID;

    public SaloonEntity(String name, String address, UUID ownerID) {
        this.name = name;
        this.address = address;
        this.ownerID = ownerID;
    }

    @Column(nullable=false)
    private Instant createdAt = Instant.now();

    public SaloonEntity() {
    }

    public SaloonEntity(String name, UUID ownerID) {
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

    public void setownerID(UUID ownerID) {
        this.ownerID = ownerID;
    }
}
