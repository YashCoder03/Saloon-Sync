package com.saas.salonsync.DTO;

import java.util.UUID;


public class ServiceRequest {

    private UUID salonId;
    private String serviceName;
    private float price;
    private long durationInSeconds;
    private String description;

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
    public ServiceRequest(UUID salonId, String serviceName, float price, long durationInseconds, String description) {
        this.salonId = salonId;
        this.serviceName = serviceName;
        this.price = price;
        this.durationInSeconds = durationInseconds;
        this.description = description;
    }

}
