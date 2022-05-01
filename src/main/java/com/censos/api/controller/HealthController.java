package com.censos.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class HealthController {
    @GetMapping(value = "/health")
    public String Entity() {
        return "Server is up";
    }

}
