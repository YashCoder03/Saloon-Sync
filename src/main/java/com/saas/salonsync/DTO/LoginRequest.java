package com.saas.salonsync.DTO;
public class LoginRequest {

    private String userName;
    private String password;

    public LoginRequest(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
