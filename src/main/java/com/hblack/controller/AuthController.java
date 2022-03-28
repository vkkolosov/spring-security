package com.hblack.controller;

import org.apache.coyote.Response;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/hello")
    public ResponseEntity hello() {
        return ResponseEntity.ok("Hello, test-auth");
    }

    @PostMapping("/login")
    public ResponseEntity login(JSONObject Body) {
        return ResponseEntity.ok("Request done");
    }



}
