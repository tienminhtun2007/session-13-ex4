package com.example.myspringbootprojectsession13.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @GetMapping("/test")
    public Map<String, String> test() {
        return Map.of(
                "message", "Public authentication endpoint is working",
                "status", "OK"
        );
    }
}
