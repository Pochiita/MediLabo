package com.front.front.controller;

import com.front.front.proxies.PatientProxy;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@Controller
@RequestMapping("/patients")
public class PatientController {


    private final PatientProxy patientProxy;

    public PatientController(PatientProxy patientProxy) {
        this.patientProxy = patientProxy;
    }

    @GetMapping("/")
    public String getAllPatients(Model model){
        try {
            ResponseEntity<?> response = patientProxy.getAllPatients();
            model.addAttribute("patients",response.getBody() != null ? response.getBody() : Collections.emptyList());
            return "patients";
        }catch(Exception e){
            model.addAttribute("error",true);
            return "patients";
        }
    }

    @GetMapping("/single/{id}")
    public String getPatientById(Model model, @PathVariable("id") int id){
        try {
            ResponseEntity<?> response = patientProxy.getPatientById(id);
            model.addAttribute("patient",response.getBody() != null ? response.getBody() : Collections.emptyList());
            return "patient";
        }catch(Exception e) {
            model.addAttribute("error",true);
            return "patient";

        }
    }
}
