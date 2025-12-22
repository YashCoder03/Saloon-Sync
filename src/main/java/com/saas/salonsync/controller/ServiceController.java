package com.saas.salonsync.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saas.salonsync.DTO.ServiceRequest;
import com.saas.salonsync.entity.ServiceEntity;
import com.saas.salonsync.service.ServiceService;


@RestController()
@RequestMapping("/api/service")
public class ServiceController {

    @Autowired
    ServiceService serviceService;

    @GetMapping("")
    public ResponseEntity<List<ServiceEntity>> getService(@RequestParam UUID saloonId){

        List<ServiceEntity> serviceList = serviceService.getAllService(saloonId);
        return ResponseEntity.ok(serviceList);

    }

    @PostMapping("")
    public ResponseEntity<String> addService(@RequestBody ServiceRequest serviceRequest){
        serviceService.addService(serviceRequest.getSaloonId(), serviceRequest);
        return ResponseEntity.ok("Service added successfully");
    }

    @DeleteMapping("")
    public void deleteService(UUID serviceId){

    }

    @GetMapping("/:id")
    public void getServiceById(@RequestParam UUID serviceId){
        
    }
    
}
