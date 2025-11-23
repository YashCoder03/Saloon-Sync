package com.saas.salonsync.DTO;

public class TenantRegisterRequest {
    private String tenantName;
    private String userName;
    private String email;
    private String password;
    public TenantRegisterRequest(String email, String password, String tenantName, String userName) {
        this.email = email;
        this.password = password;
        this.tenantName = tenantName;
        this.userName = userName;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
