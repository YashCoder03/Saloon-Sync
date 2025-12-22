package com.saas.salonsync.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="staff")
public class StaffEntity {
    

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private  UUID id;

    @Column(nullable=false)
    private UUID saloonId;

    @Column(nullable=false)
    private String role;

    @Column(nullable=false)
    private UUID userId;

    public StaffEntity(UUID id, UUID saloonId, String role, UUID userId) {
        this.id = id;
        this.saloonId = saloonId;
        this.role = role;
        this.userId = userId;
    }

    public StaffEntity(){

    }

    public StaffEntity(UUID salonId, String role, UUID userId) {
        this.saloonId = salonId;
        this.role = role;
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getsaloonId() {
        return saloonId;
    }

    public void setsaloonId(UUID saloonId) {
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



}
