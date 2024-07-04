package com.eugenio.streamming.app.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping(
            value = "home",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> getHome() {
        return ResponseEntity.ok("home");
    }
}
