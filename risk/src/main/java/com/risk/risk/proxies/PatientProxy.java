package com.risk.risk.proxies;

import com.risk.risk.DTO.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="patient",url = "http://localhost:8090/patients")

public interface PatientProxy {
    @GetMapping(value = "/single/{id}")
    ResponseEntity<PatientDTO> getPatientById(@PathVariable("id") int id);
}
