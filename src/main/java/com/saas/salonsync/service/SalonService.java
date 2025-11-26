package com.saas.salonsync.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saas.salonsync.DTO.CreatesalonRequest;
import com.saas.salonsync.entity.SalonEntity;
import com.saas.salonsync.repository.SalonRepository;

@Service
public class SalonService {
    
    @Autowired
    private SalonRepository salonRepository;
    
    public List<SalonEntity> getsalonList(){
        List<SalonEntity> salonList= salonRepository.findAll();
        return salonList;
    }

    public Optional<SalonEntity> getsalonById(UUID salonId){
        Optional<SalonEntity> salon= salonRepository.findById(salonId);
        return salon;
    }
    
    public SalonEntity createsalon(CreatesalonRequest createsalonRequest){

        SalonEntity SalonEntity = new SalonEntity(createsalonRequest.getName(),
                                                createsalonRequest.getAddress(),
                                                createsalonRequest.getOwnerId());

        SalonEntity createdsalon = salonRepository.save(SalonEntity);
        return createdsalon;
    }

    public void deletesalonById(UUID salonId){
        salonRepository.deleteById(salonId);
    }
}
