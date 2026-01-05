package com.saas.salonsync.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saas.salonsync.DTO.CreatesalonRequest;
import com.saas.salonsync.entity.SalonEntity;
import com.saas.salonsync.service.SalonService;




@RestController
@RequestMapping("/api/salon")
public class salonController {

    @Autowired
    SalonService salonService;

    @GetMapping("")
    public ResponseEntity<List<SalonEntity>> getsalonList() {
        List<SalonEntity> salonList = salonService.getsalonList();

        return ResponseEntity.ok(salonList);

    }

    @PostMapping("")
    public SalonEntity createsalon(@RequestBody CreatesalonRequest createsalonRequest) {
        SalonEntity salon = salonService.createsalon(createsalonRequest);
        return salon;
    }

    @GetMapping("/{salonId}")
    public ResponseEntity<SalonEntity> getsalonById(@PathVariable UUID salonId) {
        Optional<SalonEntity> salon = salonService.getsalonById(salonId);
        if(!salon.isPresent()){
            return ResponseEntity.ok(salon.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{salonId}")
    public ResponseEntity<String> deletesalonById(@PathVariable UUID salonId){

        salonService.deletesalonById(salonId);
        return ResponseEntity.ok("salon Deleted");
    }
}
