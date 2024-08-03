package com.patient.patient.controller;

import com.patient.patient.DTO.PatientDTO;
import com.patient.patient.models.Patient;
import com.patient.patient.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/all")
    public ResponseEntity<?> allPatients() {
        try{
            List<PatientDTO> patients = patientService.getAllPatients();
            return ResponseEntity.ok(patients);
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occured when fetching all patients");
        }
    }

    @GetMapping("/single/{id}")
    public ResponseEntity<?> patientById (@PathVariable int id){
        try{
            PatientDTO patient = patientService.getPatientById(id);
            return ResponseEntity.ok(patient);
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred when fetching patient with id "+ id);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPatient(@RequestBody PatientDTO patientDTO){
        try{
            Patient patient = patientService.createPatient(patientDTO);
            return ResponseEntity.ok(patient);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occured when trying to save the patient");
        }
    }


}
