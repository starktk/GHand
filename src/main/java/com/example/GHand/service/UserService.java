package com.example.GHand.service;

import com.example.GHand.dto.user.UserCreateDto;
import com.example.GHand.dto.user.UserDeleteDto;
import com.example.GHand.dto.UserDto;
import com.example.GHand.repository.MongoUserDB;
import com.fasterxml.jackson.databind.ObjectMapper;


public class
UserService {

    private ObjectMapper objectMapper;
    private final MongoUserDB mongoUserDB;

    public UserService(MongoUserDB mongoUserDB) {
        this.mongoUserDB = mongoUserDB;
    }

    public UserDto criarUsuario(UserCreateDto userCreateDto) {
        if (userCreateDto == null) {
            
        }
        UserDto user = objectMapper.convertValue(mongoUserDB.createUser(userCreateDto), UserDto.class);
        return user;
    }

    public UserDto buscarUsuario(String name) {
        if (name.isEmpty()) {

        }
        UserDto user = objectMapper.convertValue(mongoUserDB.findUser(name), UserDto.class);
        return user;
    }

    public void deletarUsuario(UserDeleteDto userDeleteDto) {

        if(userDeleteDto.getName().isEmpty() && userDeleteDto.getPassword().isEmpty()) {
            throw new RuntimeException("Nome ou senha incorretos");
        }
        mongoUserDB.deleteUser(userDeleteDto.getName(), userDeleteDto.getPassword());
    }
}

