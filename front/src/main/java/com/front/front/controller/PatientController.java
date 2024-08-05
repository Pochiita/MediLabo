package com.front.front.controller;

import com.front.front.DTO.PatientDTO;
import com.front.front.proxies.PatientProxy;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
            model.addAttribute("patient",response.getBody());
            return "patient";
        }catch(Exception e) {
            model.addAttribute("notFindable",true);
            return "patient";

        }
    }

    @GetMapping("/single/add")
    public String createPatientPage(Model model){
        PatientDTO patient = new PatientDTO();
        model.addAttribute("patient",patient);
        return "addPatient";
    }

    @PostMapping("/single/add/process")
    public String createPatientProcess (@Valid @ModelAttribute("patient") PatientDTO patientDTO, BindingResult results,Model model){
        if (results.hasErrors() || results.hasFieldErrors()){
            model.addAttribute("patient",patientDTO);
            return "addPatient";
        }

        try {
            ResponseEntity<?> response = patientProxy.addPatient(patientDTO);
            return "redirect:/patients";
        }catch(Exception e) {
            model.addAttribute("error",true);
            return "redirect:/patients/single/add";
        }
    }

    @GetMapping("/single/modify/{id}")
    public String modifyPatientPage(Model model,@PathVariable("id") int id){
        try {
            ResponseEntity<?> response = patientProxy.getPatientById(id);
            model.addAttribute("patient",response.getBody());
            return "modifyPatient";
        }catch(Exception e) {
            model.addAttribute("notFindable",true);
            return "modifyPatient";
        }
    }

    @PostMapping("/single/modify/process/{id}")
    public String modifyPatientProcess (@Valid @ModelAttribute("patient")PatientDTO patientDTO,@PathVariable("id") int id, BindingResult results,Model model){
        if (results.hasErrors() || results.hasFieldErrors()){
            model.addAttribute("patient",patientDTO);
            return "modifyPatient";
        }

        try {
            ResponseEntity<?> response = patientProxy.modifyPatient(patientDTO,id);
            return "redirect:/patients/single/"+id;
        }catch(Exception e) {
            model.addAttribute("error",true);
            return "redirect:/patients/single/modify/"+id;
        }
    }

    @GetMapping("/single/delete/process/{id}")
    public String deletePatientProcess (@PathVariable("id") int id,Model model) {
        try {
            ResponseEntity<?> response = patientProxy.deletePatient(id);
            return "redirect:/patients/";
        }catch(Exception e) {
            model.addAttribute("notDeletable",true);
            return "redirect:/patients/single/"+id;
        }
    }
}
