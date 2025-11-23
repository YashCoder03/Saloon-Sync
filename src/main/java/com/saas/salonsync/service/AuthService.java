package com.saas.salonsync.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.saas.salonsync.DTO.JWTToken;
import com.saas.salonsync.DTO.LoginRequest;
import com.saas.salonsync.DTO.LoginResposne;
import com.saas.salonsync.DTO.RegisterRequest;
import com.saas.salonsync.entity.UserEntity;
import com.saas.salonsync.repository.UserRepository;
import com.saas.salonsync.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private JwtUtil jwtUtil;
    

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RefreshTokenService refreshTokenService;

    @Autowired 

    public LoginResposne loginUser(LoginRequest loginRequest){
        UserEntity user = userRepository.findByUsername(loginRequest.getUsername());

        if(user == null || !passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new RuntimeException("User not found");
        }

        
        JWTToken accessToken = new JWTToken(jwtUtil.generateToken(loginRequest.getUsername()));
        String refreshToken = refreshTokenService.createForUser(user.getId());

        return new LoginResposne(refreshToken,accessToken.getToken());    
    }

    public UserEntity registerUser(RegisterRequest registerRequest){
        
        // Encode the password using BCrypt before saving
        String hashPassword = passwordEncoder.encode(registerRequest.getPassword());
        UserEntity user = new UserEntity(registerRequest.getEmail(),hashPassword, registerRequest.getUserName());
        userRepository.save(user);  

        return user;

    }
    
}
