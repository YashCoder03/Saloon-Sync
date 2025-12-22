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

    public List<ServiceEntity> getAllService(UUID saloonId) {
        List<ServiceEntity> results = serviceRepository.findBySaloonId(saloonId);
        return results;
    }

    public ServiceEntity getServiceById(UUID tenantId,UUID serviceId) {
        ServiceEntity results = serviceRepository.findByIdAndSaloonId(serviceId, tenantId);
        return results;
    }

    public void deleteServiceById(UUID tenantId,UUID serviceId){
        serviceRepository.deleteById(serviceId);
    }

    public void addService(UUID saloonId, ServiceRequest serviceRequest){

        ServiceEntity serviceEntity = new ServiceEntity(saloonId, serviceRequest.getServiceName(), 
                                            serviceRequest.getPrice(),
                                            serviceRequest.getDurationInseconds(), 
                                            serviceRequest.getDescription());

        serviceRepository.save(serviceEntity);
    }

}
