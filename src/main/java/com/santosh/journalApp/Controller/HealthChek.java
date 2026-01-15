package com.santosh.journalApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthChek {

    @GetMapping("/health-chek")
    public String healthChek(){
        return "Ok";
    }
}
