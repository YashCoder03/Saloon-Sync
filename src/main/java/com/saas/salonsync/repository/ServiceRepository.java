package com.saas.salonsync.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saas.salonsync.entity.ServiceEntity;

public interface ServiceRepository extends  JpaRepository<ServiceEntity,UUID>{

    ServiceEntity findByServiceIdSalonId(UUID serviceId,UUID salonId);

}
