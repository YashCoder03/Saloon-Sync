package com.saas.salonsync.DTO;

import java.util.UUID;


public class ServiceRequest {

    private UUID saloonId;
    private String serviceName;
    private float price;
    private long durationInSeconds;
    private String description;

    public UUID getSaloonId() {
        return saloonId;
    }
    public void setSaloonId(UUID saloonId) {
        this.saloonId = saloonId;
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
    public ServiceRequest(UUID saloonId, String serviceName, float price, long durationInseconds, String description) {
        this.saloonId = saloonId;
        this.serviceName = serviceName;
        this.price = price;
        this.durationInSeconds = durationInseconds;
        this.description = description;
    }

}
