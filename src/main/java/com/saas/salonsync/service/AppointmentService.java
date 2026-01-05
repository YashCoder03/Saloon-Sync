package com.saas.salonsync.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.saas.salonsync.DTO.AppointmentRequest;
import com.saas.salonsync.entity.AppointmentEntity;
import com.saas.salonsync.repository.AppointmentRepository;

public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<AppointmentEntity> getAllAppointmentsBySalonId(UUID salonId) {
        return appointmentRepository.findBySalonId(salonId);
    }
    
    public AppointmentEntity createAppointment(AppointmentRequest appointment) {

        AppointmentEntity entity = new AppointmentEntity();
        entity.setSalonId(appointment.getSalonId());
        entity.setCustomerId(appointment.getCustomerId());
        entity.setStaffId(appointment.getStaffId());
        entity.setServiceId(appointment.getServiceId());
        entity.setStartTime(appointment.getStartTime());
        entity.setStatus(appointment.getStatus());
        entity.setPrice(appointment.getPrice());

        AppointmentEntity savEntity =  appointmentRepository.save(entity);
        return savEntity;   
    }   

    public void deleteAppointmentById(UUID appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
