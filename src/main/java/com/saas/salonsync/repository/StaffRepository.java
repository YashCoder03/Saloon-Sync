package com.saas.salonsync.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saas.salonsync.entity.StaffEntity;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, UUID> {
    List<StaffEntity> findBySalonId(UUID salonId);


    @Query("SELECT s FROM staff s " +
           "LEFT JOIN appointment a ON s.id = a.staff_id " +
           "AND a.start_time = :date " +
           "WHERE s.salon_id = :salonId " +
           "AND a.id IS NULL")
    List<StaffEntity> findAvailableStaffBySalonAndDate(
        @Param("salonId") UUID salonId, 
        @Param("date") Date date);
}
