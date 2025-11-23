package com.saas.salonsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saas.salonsync.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    
    UserEntity findByUsername(String userName);
}
