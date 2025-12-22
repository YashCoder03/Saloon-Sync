package com.saas.salonsync.DTO;

import java.util.UUID;


public class ServiceRequest {

    private UUID saloonId;
    private String serviceName;
    private float price;
    private int durationInseconds;
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
    public ServiceRequest(UUID saloonId, String serviceName, float price, int durationInseconds, String description) {
        this.saloonId = saloonId;
        this.serviceName = serviceName;
        this.price = price;
        this.durationInseconds = durationInseconds;
        this.description = description;
    }

}
