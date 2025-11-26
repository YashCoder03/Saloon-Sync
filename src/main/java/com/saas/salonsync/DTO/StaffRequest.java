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

    public UUID getSaloonId() {
        return saloonId;
    }

    public void setSaloonId(UUID saloonId) {
        this.saloonId = saloonId;
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

    public StaffRequest(UUID id, UUID saloonId, String role, UUID userId) {
        this.id = id;
        this.saloonId = saloonId;
        this.role = role;
        this.userId = userId;
    }
    
}
