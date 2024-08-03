package com.front.front.proxies;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "patient", url="localhost:8090/patients")
public interface PatientProxy {

    @GetMapping(value = "/all")
    ResponseEntity<?> getAllPatients();

    @GetMapping(value = "/single/{id}")
    ResponseEntity<?> getPatientById(@PathVariable("id") int id);
}
