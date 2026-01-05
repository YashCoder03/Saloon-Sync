package com.saas.salonsync.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saas.salonsync.DTO.ServiceRequest;
import com.saas.salonsync.entity.ServiceEntity;
import com.saas.salonsync.repository.ServiceRepository;

@Service
public class ServiceService {
    

    @Autowired
    private ServiceRepository serviceRepository;

    public List<ServiceEntity> getAllService(UUID salonId) {
        List<ServiceEntity> results = serviceRepository.findBySalonId(salonId);
        return results;
    }

    public ServiceEntity getServiceById(UUID salonId,UUID serviceId) {
        ServiceEntity results = serviceRepository.findByIdAndSalonId(serviceId, salonId);
        return results;
    }

    public void deleteServiceById(UUID serviceId){
        serviceRepository.deleteById(serviceId);
    }

    public void addService(UUID salonId, ServiceRequest serviceRequest){

        ServiceEntity serviceEntity = new ServiceEntity(salonId, serviceRequest.getServiceName(), 
                                            serviceRequest.getPrice(),
                                            serviceRequest.getDurationInSeconds(), 
                                            serviceRequest.getDescription());

        serviceRepository.save(serviceEntity);
    }

}
