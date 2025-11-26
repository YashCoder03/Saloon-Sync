package com.saas.salonsync.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saas.salonsync.entity.SalonEntity;

@Repository
public interface SalonRepository  extends  JpaRepository<SalonEntity, UUID>{
    Optional<SalonEntity> findById(UUID id);
    Optional<SalonEntity> findByName(String name);
}
