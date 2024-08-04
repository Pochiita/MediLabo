package com.front.front.proxies;


import com.front.front.DTO.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "patient", url="localhost:8090/patients")
public interface PatientProxy {

    @GetMapping(value = "/all")
    ResponseEntity<?> getAllPatients();

    @GetMapping(value = "/single/{id}")
    ResponseEntity<?> getPatientById(@PathVariable("id") int id);

    @PostMapping(value = "/single/add")
    ResponseEntity<?> addPatient(@RequestBody PatientDTO patientDTO);

    @PostMapping(value="single/modify/{id}")
    ResponseEntity<?> modifyPatient(@RequestBody PatientDTO patientDTO,@PathVariable("id") int id);

    @PostMapping(value="single/delete/{id}")
    ResponseEntity<?> deletePatient(@PathVariable("id") int id);
}
