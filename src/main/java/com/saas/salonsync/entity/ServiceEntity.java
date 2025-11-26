package com.saas.salonsync.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ServiceEntity {

    @Id
    @Column(nullable=false)
    private UUID id = UUID.randomUUID();

    @Column(nullable=false)
    private UUID salonId;

    @Column(nullable=false)
    private String serviceName;

    @Column(nullable=false)
    private float price;

    @Column(nullable=false)
    private int durationInseconds;

    @Column(nullable=true)
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSalonId() {
        return salonId;
    }

    public void setSalonId(UUID salonId) {
        this.salonId = salonId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDurationInseconds() {
        return durationInseconds;
    }

    public void setDurationInseconds(int durationInseconds) {
        this.durationInseconds = durationInseconds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ServiceEntity(UUID id, UUID salonId, String serviceName, float price, int durationInseconds,
            String description) {
        this.id = id;
        this.salonId = salonId;
        this.serviceName = serviceName;
        this.price = price;
        this.durationInseconds = durationInseconds;
        this.description = description;
    }

    public ServiceEntity(UUID salonId, String serviceName, float price, int durationInseconds, String description) {
        this.salonId = salonId;
        this.serviceName = serviceName;
        this.price = price;
        this.durationInseconds = durationInseconds;
        this.description = description;
    }

    public ServiceEntity() {
    }
    
}
