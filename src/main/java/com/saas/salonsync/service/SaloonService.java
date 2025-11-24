package com.saas.salonsync.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saas.salonsync.DTO.CreateSaloonRequest;
import com.saas.salonsync.entity.SaloonEntity;
import com.saas.salonsync.repository.SaloonRepository;

@Service
public class SaloonService {
    
    @Autowired
    private SaloonRepository saloonRepository;
    
    public List<SaloonEntity> getSaloonList(){
        List<SaloonEntity> saloonList= saloonRepository.findAll();
        return saloonList;
    }

    public Optional<SaloonEntity> getSaloonById(UUID saloonId){
        Optional<SaloonEntity> saloon= saloonRepository.findById(saloonId);
        return saloon;
    }
    
    public SaloonEntity createSaloon(CreateSaloonRequest createSaloonRequest){

        SaloonEntity saloonEntity = new SaloonEntity(createSaloonRequest.getName(),
                                                createSaloonRequest.getAddress(),
                                                createSaloonRequest.getOwnerId());

        SaloonEntity createdSaloon = saloonRepository.save(saloonEntity);
        return createdSaloon;
    }

    public void deleteSaloonById(UUID saloonId){
        saloonRepository.deleteById(saloonId);
    }
}
