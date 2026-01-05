package com.saas.salonsync.DTO;

import java.util.UUID;


public class StaffRequest {

    private UUID id ;

    private UUID salonId;

    private String role;

    private UUID userId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSalonId() {
        return salonId;
    }

    public void setsalonId(UUID salonId) {
        this.salonId = salonId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public StaffRequest(UUID id, UUID salonId, String role, UUID userId) {
        this.id = id;
        this.salonId = salonId;
        this.role = role;
        this.userId = userId;
    }
    
}
