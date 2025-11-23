package com.saas.salonsync.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saas.salonsync.entity.SaloonEntity;

@Repository
public interface  SaloonRepository  extends  JpaRepository<SaloonEntity, UUID>{
    Optional<SaloonEntity> findById(UUID id);
    Optional<SaloonEntity> findByName(String name);
}
