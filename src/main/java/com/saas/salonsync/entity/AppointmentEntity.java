package com.saas.salonsync.entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="appointment")
public class AppointmentEntity {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(name="salon_id", nullable = false)
    private UUID salonId;

    @Column(name="customer_id", nullable = false)   
    private UUID customerId;
    
    @Column(name="staff_id", nullable = false)
    private UUID staffId;

    @Column(name="service_id", nullable = false)    
    private UUID serviceId;

    @Column(name="start_time", nullable = false)
    private Date startTime;
    


    @Column(name="status", nullable = false)
    private String status;

    @Column(name="price", nullable = false) 
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

    public AppointmentEntity(UUID salonId, UUID customerId, UUID staffId, UUID serviceId, Date startTime, Date endTime,
            String status, Float price) {
        this.salonId = salonId;
        this.customerId = customerId;
        this.staffId = staffId;
        this.serviceId = serviceId;
        this.startTime = startTime;
        this.status = status;
        this.price = price;
    }
    public AppointmentEntity() {

        
    }
}
