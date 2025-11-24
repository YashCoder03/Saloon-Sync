package com.saas.salonsync.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saas.salonsync.entity.StaffEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/staff")
public class StaffController {
    
    @GetMapping("/:id")
    public ResponseEntity<StaffEntity> getStaffDetails(@RequestParam UUID saloonId) {
        
    }

    @PostMapping("/")
    public String addStaff(@RequestBody String entity) {

        return entity;
    }

    @DeleteMapping("/:id&:staffId")
    
    
}
