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
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()   // allow everything
                )
                .sessionManagement(session -> session.disable()) // no session
                .securityContext(security -> security.disable()) // disable security context
                .headers(headers -> headers.frameOptions().disable()); // for H2 console if needed

        return http.build();
    }
}
