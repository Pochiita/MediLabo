package com.gateway.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContrller {

    @GetMapping("/health")
    public String health() {
        return "Gateway is up and running!";
    }
}
