package com.patient.patient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/visa")
    public String health() {
        return "Patient is up and running!";
    }
}
