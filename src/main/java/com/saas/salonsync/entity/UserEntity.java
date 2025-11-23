package com.saas.salonsync.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity()
public class UserEntity {
    
    @Id
    @Column(unique = true, nullable = false)
    private UUID id  = UUID.randomUUID();

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique= true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    // Default constructor required by JPA
    public UserEntity() {
    }

    public UserEntity(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getId() {
        return id;
    }
}
