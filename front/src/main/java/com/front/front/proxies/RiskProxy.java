package com.front.front.proxies;

import com.front.front.DTO.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "risk", url="gateway:8090/risks")

public interface RiskProxy {

    @GetMapping(value = "/single/{id}")
    String getPatientById(@PathVariable("id") int id);
}
