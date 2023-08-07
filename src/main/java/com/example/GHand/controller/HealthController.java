package com.example.GHand.controller;

import com.example.GHand.document.User;
import com.example.GHand.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Health")
public class HealthController {

    @GetMapping("/Conect")
    public ResponseEntity<String> conectado() {
        return ResponseEntity.ok("Up com sucesso");
    }
}
