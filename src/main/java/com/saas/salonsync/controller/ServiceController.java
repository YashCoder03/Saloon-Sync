package com.saas.salonsync.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saas.salonsync.DTO.ServiceRequest;


@RestController()
@RequestMapping("/api/service")
public class ServiceController {


    @GetMapping("/")
    public void getService(){

    }

    @PostMapping("/")
    public void addService(@RequestBody ServiceRequest serviceRequest){

    }

    @DeleteMapping("/")
    public void deleteService(UUID serviceId){

    }

    @GetMapping(":id")
    public void getServiceById(@RequestParam UUID serviceId){
        
    }
    
}
