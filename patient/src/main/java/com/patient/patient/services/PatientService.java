package com.patient.patient.services;

import com.patient.patient.DTO.PatientDTO;
import com.patient.patient.exceptions.PatientNotFoundException;
import com.patient.patient.models.Patient;
import com.patient.patient.repository.PatientRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientDTO> getAllPatients(){
        List<Patient> patientsList = patientRepository.findAll();

        return patientsList.stream()
                .map(patient -> {
                    PatientDTO patientDTO = new PatientDTO();
                    BeanUtils.copyProperties(patient,patientDTO);
                    return patientDTO;
                }).collect(Collectors.toList());
    }

    public PatientDTO getPatientById(long id){

        Optional<Patient> patient = patientRepository.findById(id);

        if (patient.isEmpty()){
            throw new PatientNotFoundException("Patient with ID " + id + " not found");
        }

        PatientDTO patientDTO = new PatientDTO();
        Patient existingPatient = patient.get();
        BeanUtils.copyProperties(existingPatient,patientDTO);
        return patientDTO;

    }

    public Patient createPatient(PatientDTO patientDTO) throws Exception {
        try {
            Patient patient = new Patient();
            BeanUtils.copyProperties(patientDTO,patient);
            return patientRepository.save(patient);
        }catch(Exception e){
            throw new Exception("Impossible to create the patient");
        }
    }
}
