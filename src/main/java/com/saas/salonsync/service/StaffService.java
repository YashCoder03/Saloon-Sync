package com.saas.salonsync.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saas.salonsync.DTO.StaffRequest;
import com.saas.salonsync.entity.StaffEntity;
import com.saas.salonsync.repository.StaffRepository;


@Service
public class StaffService {
    
    @Autowired
    StaffRepository staffRepository;

    public List<StaffEntity> getAllStaffBySalonId(UUID salonId){

        List<StaffEntity> staffList = staffRepository.findBySalonId(salonId);
        
        return staffList;

    }
    public void addStaff(StaffRequest staffRequest){
        StaffEntity newStaffEntity = new StaffEntity(staffRequest.getSalonId(), staffRequest.getRole(), staffRequest.getUserId());
        staffRepository.save(newStaffEntity);
    }

    public void deleteStaffById(UUID staffId){
        staffRepository.deleteById(staffId);
    }

    public List<StaffEntity> getAvailableStaffBySalonId(UUID salonId, Date appointmentDate) {
        List<StaffEntity> availableStaffList = staffRepository.findAvailableStaffBySalonAndDate(salonId, appointmentDate);
        return availableStaffList;
    }
}
