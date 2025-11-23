package com.saas.salonsync.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saas.salonsync.entity.SaloonEntity;
import com.saas.salonsync.service.SaloonService;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.saas.salonsync.DTO.CreateSaloonRequest;



@RestController
@RequestMapping("/api/saloon")
public class SaloonController {

    @Autowired
    SaloonService saloonService;

    @GetMapping("")
    public ResponseEntity<List<SaloonEntity>> getSaloonList() {
        List<SaloonEntity> saloonList = saloonService.getSaloonList();

        return ResponseEntity.ok(saloonList);

    }

    @PostMapping("")
    public SaloonEntity createSaloon(@RequestBody CreateSaloonRequest createSaloonRequest) {
        SaloonEntity saloon = saloonService.createSaloon(createSaloonRequest);
        return saloon;
    }

    @GetMapping(":id")
    public ResponseEntity<SaloonEntity> getSaloonById(@RequestParam UUID saloonId) {
        Optional<SaloonEntity> saloon = saloonService.getSaloonById(saloonId);
        if(!saloon.isPresent()){
            return ResponseEntity.ok(saloon.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }
    
    
    
}
