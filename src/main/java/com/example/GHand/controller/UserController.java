package com.example.GHand.controller;

import com.example.GHand.dto.user.UserCreateDto;
import com.example.GHand.dto.user.UserDto;
import com.example.GHand.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserCreateDto userCreateDto) {
        return new ResponseEntity<>(userService.criarUsuario(userCreateDto), HttpStatus.CREATED);
    }

    @GetMapping("/getuser/{name}")
    public ResponseEntity<UserDto> findUser(@PathVariable ("name") String name) {
        return new ResponseEntity<>(userService.buscarUsuario(name), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity deleteUser(@RequestBody UserDto userDto) {
        userService.deletarUsuario(userDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/alterPassword")
    public ResponseEntity<UserDto> updatePassword(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.alterarSenha(userDto), HttpStatus.ACCEPTED);
    }

    @PutMapping("/alterUser")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.alterarUsuario(userDto), HttpStatus.ACCEPTED);
    }
}