package com.example.GHand.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Health")
public class HealthController {

    @GetMapping("/Conect")
    public ResponseEntity<String> conectado() {
        return ResponseEntity.ok("Up com sucesso");
    }
}
