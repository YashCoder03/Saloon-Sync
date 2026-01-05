package com.saas.salonsync.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saas.salonsync.DTO.AppointmentRequest;
import com.saas.salonsync.entity.AppointmentEntity;
import com.saas.salonsync.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;


    @GetMapping("")
    public ResponseEntity<List<AppointmentEntity>> getAllAppointments(@RequestParam UUID salonId) {
        List<AppointmentEntity> appointments = appointmentService.getAllAppointmentsBySalonId(salonId);
        return ResponseEntity.ok(appointments);
    }

    @PostMapping("")
    public ResponseEntity<AppointmentEntity> createAppointment(@RequestBody AppointmentRequest appointment) {
        AppointmentEntity createdAppointment = appointmentService.createAppointment(appointment);
        return ResponseEntity.ok(createdAppointment);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteAppointment(@RequestParam UUID appointmentId) {
        appointmentService.deleteAppointmentById(appointmentId);
        return ResponseEntity.ok("Appointment Cancelled Successfully");
    }

}
