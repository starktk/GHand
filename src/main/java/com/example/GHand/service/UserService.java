package com.example.GHand.service;

import com.example.GHand.dto.user.UserCreateDto;
import com.example.GHand.dto.user.UserDto;
import com.example.GHand.repository.mongodatabases.MongoUserDB;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

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

    public void deletarUsuario(UserDto userDto) {
        if(userDto.getName().isEmpty() && userDto.getPassword().isEmpty()) {
            throw new RuntimeException("Nome ou senha incorretos");
        }
        mongoUserDB.deleteUser(userDto.getName(), userDto.getPassword());
    }

    public UserDto alterarSenha(UserDto userDto) {
        if (userDto.getName().isEmpty() && userDto.getPassword().isEmpty()) {
            throw new RuntimeException("Preencha a senha novamente");
        }

        return objectMapper.convertValue(mongoUserDB.updatePassword(userDto.getName(), userDto.getPassword()), UserDto.class);
    }

    public UserDto alterarUsuario(UserDto userDto) {
        if (userDto.getName().isEmpty() && userDto.getEmail().isEmpty()) {
            throw new RuntimeException("Preencha os campos novamente");
        }

        return objectMapper.convertValue(mongoUserDB.updatePassword(userDto.getName(), userDto.getEmail()), UserDto.class);
    }
}

