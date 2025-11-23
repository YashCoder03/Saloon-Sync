package com.saas.salonsync.DTO;

public class TokenResponse {
    private String accessToken;
    public TokenResponse(String accessToken) { this.accessToken = accessToken; }
    public String getAccessToken() { return accessToken; }
}