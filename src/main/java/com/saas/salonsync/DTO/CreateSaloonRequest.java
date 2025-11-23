package com.saas.salonsync.DTO;

import java.util.UUID;

public class CreateSaloonRequest {

    private String name;
    private String address;
    private UUID ownerId;

    public CreateSaloonRequest(String address, String name, UUID ownerId) {
        this.address = address;
        this.name = name;
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }
    
}
