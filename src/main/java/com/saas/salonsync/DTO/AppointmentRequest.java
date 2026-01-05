package com.saas.salonsync.DTO;

import java.util.Date;
import java.util.UUID;


public class AppointmentRequest {

    private UUID id;
    
    private UUID salonId;

    private UUID customerId;
    
    private UUID staffId;

    private UUID serviceId;

    private Date startTime;
    
    private String status;

    private Float price;

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

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getStaffId() {
        return staffId;
    }

    public void setStaffId(UUID staffId) {
        this.staffId = staffId;
    }

    public UUID getServiceId() {
        return serviceId;
    }

    public void setServiceId(UUID serviceId) {
        this.serviceId = serviceId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

   

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public AppointmentRequest(UUID salonId, UUID customerId, UUID staffId, UUID serviceId, Date startTime, Date endTime,
            String status, Float price) {
        this.salonId = salonId;
        this.customerId = customerId;
        this.staffId = staffId;
        this.serviceId = serviceId;
        this.startTime = startTime;
        this.status = status;
        this.price = price;
    }
    
}
