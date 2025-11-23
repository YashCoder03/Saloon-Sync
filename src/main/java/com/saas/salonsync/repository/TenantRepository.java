package com.saas.salonsync.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saas.salonsync.entity.TenantEntity;

@Repository
public interface  TenantRepository  extends  JpaRepository<TenantEntity, UUID>{
    Optional<TenantEntity> findById(UUID id);
    Optional<TenantEntity> findByName(String name);
}
