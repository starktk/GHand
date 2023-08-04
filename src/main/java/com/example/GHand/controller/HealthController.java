package com.example.GHand.controller;

import com.example.GHand.document.User;
import com.example.GHand.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/teste")
public class HealthController {

    public UserService userService;

    public HealthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> criarUsuario(@RequestBody User user) {
        return new ResponseEntity<>(userService.criarUsuario(user), HttpStatus.CREATED);
    }
}
