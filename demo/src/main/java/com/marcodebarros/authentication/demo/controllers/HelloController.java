package com.marcodebarros.authentication.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
@CrossOrigin(origins = "http://localhost:4200")
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/authenticated-hello")
    public ResponseEntity<String> authenticatedHello(){
        return ResponseEntity.ok("Hello");
    }
}
