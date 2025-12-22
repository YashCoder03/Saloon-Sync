package com.saas.salonsync.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saas.salonsync.entity.ServiceEntity;

public interface ServiceRepository extends  JpaRepository<ServiceEntity,UUID>{

    ServiceEntity findByIdAndSaloonId(UUID serviceId,UUID salonId);
    List<ServiceEntity> findBySaloonId(UUID saloonId);
}
