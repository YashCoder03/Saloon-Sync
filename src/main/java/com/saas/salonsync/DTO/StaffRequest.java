package com.saas.salonsync.DTO;

import java.util.UUID;


public class StaffRequest {

    private UUID id ;

    private UUID saloonId;

    private String role;

    private UUID userId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getsaloonId() {
        return saloonId;
    }

    public void setsaloonId(UUID salonId) {
        this.saloonId = salonId;
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
        this.saloonId = salonId;
        this.role = role;
        this.userId = userId;
    }
    
}
