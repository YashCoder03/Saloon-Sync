package com.saas.salonsync.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF protection completely
                .csrf(csrf -> csrf.disable())
                // Allow requests to any URL
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )
                // Allow the H2 console to load within a frame
                .headers(headers -> headers.frameOptions().sameOrigin()) 
                // Disable session management (optional, based on your original code)
                .sessionManagement(session -> session.disable())
                // Disable security context (optional, based on your original code)
                .securityContext(security -> security.disable()); 

        return http.build();
    }
}
