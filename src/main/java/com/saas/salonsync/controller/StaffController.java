package com.saas.salonsync.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saas.salonsync.DTO.StaffRequest;
import com.saas.salonsync.entity.StaffEntity;
import com.saas.salonsync.service.StaffService;




@RestController
@RequestMapping("/api/staff")
public class StaffController {
    
    @Autowired
    StaffService staffService;

    @GetMapping("")
    public ResponseEntity<List<StaffEntity>> getAllStaff(@RequestParam UUID saloonId) {
        List<StaffEntity> staffList = staffService.getAllStaffBysaloonId(saloonId);
        return ResponseEntity.ok(staffList); 
    }

    @PostMapping("")
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
