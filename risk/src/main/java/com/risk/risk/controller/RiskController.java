package com.risk.risk.controller;

import com.risk.risk.services.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/risks")
public class RiskController {

   @Autowired
   RiskService riskService;

    @GetMapping("/single/{id}")
    public String patientById (@PathVariable("id") int id){
        try{
            return riskService.getRiskLevel(id);
        }catch(Exception e) {
            return String.valueOf(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
    }
}
