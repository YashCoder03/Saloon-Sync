package com.saas.salonsync.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

import com.saas.salonsync.DTO.JWTToken;
import com.saas.salonsync.DTO.LoginRequest;
import com.saas.salonsync.DTO.LoginResposne;
import com.saas.salonsync.DTO.RegisterRequest;
import com.saas.salonsync.DTO.TokenResponse;
import com.saas.salonsync.entity.UserEntity;
import com.saas.salonsync.service.AuthService;

import org.springframework.http.HttpHeaders;

import com.saas.salonsync.DTO.TenantRegisterRequest;
import com.saas.salonsync.entity.TenantEntity;

import lombok.extern.slf4j.Slf4j;


@RestController()
@Slf4j
@RequestMapping("/auth/api")
public class AuthController {

    private static final long COOKIE_AGE = Duration.ofDays(30).getSeconds();
    private static final String REFRESH_COOKIE = "refresh_token";

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    ResponseEntity<TokenResponse> loginUser(@RequestBody LoginRequest loginRequest){
        LoginResposne loginResposne =  authService.loginUser(loginRequest);
        ResponseCookie cookie = ResponseCookie.from(REFRESH_COOKIE, loginResposne.getRefreshToken())
                .httpOnly(true)
                .secure(true) // set false for local dev without HTTPS
                .path("/api/auth")
                .maxAge(COOKIE_AGE)
                .sameSite("Lax")
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new TokenResponse(loginResposne.getAccessToken()));
    }

    @PostMapping("/register")
    ResponseEntity<UserEntity> registerUser(@RequestBody RegisterRequest registerRequest){
        UserEntity user = authService.registerUser(registerRequest);
        return ResponseEntity.ok(user);
    }


    @PostMapping("/tenant/register")
    public ResponseEntity<TenantEntity> registerTenant(@RequestBody TenantRegisterRequest tenant) {
        
        TenantEntity createdTenant= authService.registerTenant(tenant);
        return ResponseEntity.ok(createdTenant);
    }
    
    
}
