package com.front.front.controller;

import com.front.front.proxies.PatientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {


    private final PatientProxy patientProxy;

    public PatientController(PatientProxy patientProxy) {
        this.patientProxy = patientProxy;
    }

    @GetMapping("/")
    public String checkup (){
        String test = String.valueOf(patientProxy.health());
        System.out.println(test);
        if (!test.isEmpty()){
            return "Hello";
        }else{
            return "Pas hello";
        }
    }
}
