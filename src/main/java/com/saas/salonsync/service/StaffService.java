package com.saas.salonsync.service;

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

    public List<StaffEntity> getAllStaffBySaloonId(UUID saloonId){

        List<StaffEntity> staffList = staffRepository.findBySaloonId(saloonId);
        
        return staffList;

    }
    public void addStaff(StaffRequest staffRequest){

        StaffEntity newStaffEntity = new StaffEntity(staffRequest.getSaloonId(), staffRequest.getRole(), staffRequest.getUserId());
        staffRepository.save(newStaffEntity);


    }

    public void deleteStaffById(UUID staffId){
        staffRepository.deleteById(staffId);
    }
}
