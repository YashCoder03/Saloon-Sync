package com.saas.salonsync.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saas.salonsync.entity.StaffEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.saas.salonsync.DTO.StaffRequest;
import com.saas.salonsync.service.StaffService;




@RestController
@RequestMapping("/api/staff")
public class StaffController {
    
    @Autowired
    StaffService staffService;

    @GetMapping("/:id")
    public ResponseEntity<List<StaffEntity>> getStaffDetails(@RequestParam UUID saloonId) {
        List<StaffEntity> staffList = staffService.getAllStaffBySaloonId(saloonId);
        return ResponseEntity.ok(staffList); 
    }

    @PostMapping("/")
    public ResponseEntity<String> addStaff(@RequestBody StaffRequest staffRequest) {
        staffService.addStaff(staffRequest);
        return ResponseEntity.ok("User Added successfully");
    }
    @DeleteMapping("/{staffId}")
    public ResponseEntity<String> deleteStaff(@PathVariable UUID staffId) {
        staffService.deleteStaffById(staffId);
        return ResponseEntity.ok("Staff deleted successfully");
    }
    
    
}
