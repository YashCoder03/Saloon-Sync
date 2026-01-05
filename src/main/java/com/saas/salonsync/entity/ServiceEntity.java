package com.saas.salonsync.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="service")
public class ServiceEntity {

    @Id
    @Column(nullable=false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private  UUID id;

    @Column(nullable=false)
    private UUID salonId;

    @Column(nullable=false)
    private String serviceName;

    @Column(nullable=false)
    private float price;

    @Column(nullable=false)
    private long durationInSeconds;

    @Column(nullable=true)
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getsalonId() {
        return salonId;
    }

    public void setsalonId(UUID salonId) {
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

    public long getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(long durationInseconds) {
        this.durationInSeconds = durationInseconds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ServiceEntity(UUID id, UUID salonId, String serviceName, float price, long durationInseconds,
            String description) {
        this.id = id;
        this.salonId = salonId;
        this.serviceName = serviceName;
        this.price = price;
        this.durationInSeconds = durationInseconds;
        this.description = description;
    }

    public ServiceEntity(UUID salonId, String serviceName, float price, long durationInSeconds, String description) {
        this.salonId = salonId;
        this.serviceName = serviceName;
        this.price = price;
        this.durationInSeconds = durationInSeconds;
        this.description = description;
    }

    public ServiceEntity() {
    }
    
}
