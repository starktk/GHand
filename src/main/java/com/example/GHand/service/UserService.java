package com.example.GHand.service;

import com.example.GHand.document.User;
import com.example.GHand.repository.MongoConection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


public class UserService {

    private final MongoConection mongoConection;

    public UserService(MongoConection mongoConection) {
        this.mongoConection = mongoConection;
    }

    public User criarUsuario(User user) {
        mongoConection.createUser(user);
        return user;
    }
}
