package com.front.front.proxies;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "patient", url="localhost:8090/patient")
public interface PatientProxy {

    @GetMapping(value = "/")
    ResponseEntity<String> health();
}
