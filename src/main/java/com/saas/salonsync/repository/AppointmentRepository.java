package com.saas.salonsync.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saas.salonsync.entity.AppointmentEntity;

public interface  AppointmentRepository extends  JpaRepository<AppointmentEntity, UUID> {

    List<AppointmentEntity> findBySalonId(UUID salonId);
    
}
