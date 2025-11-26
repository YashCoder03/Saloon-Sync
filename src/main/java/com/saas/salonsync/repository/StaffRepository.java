package com.saas.salonsync.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saas.salonsync.entity.StaffEntity;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, UUID> {
    List<StaffEntity> findBySaloonId(UUID saloonId);
}
