package com.saas.salonsync.DTO;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class ServiceRequest {

    private UUID id ;
    private UUID salonId;
    private String serviceName;
    private float price;
    private int durationInseconds;
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
    public ServiceRequest(UUID salonId, String serviceName, float price, int durationInseconds, String description) {
        this.salonId = salonId;
        this.serviceName = serviceName;
        this.price = price;
        this.durationInseconds = durationInseconds;
        this.description = description;
    }

}
