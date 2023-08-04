package com.example.GHand.service;

import com.example.GHand.document.User;
import com.example.GHand.repository.MongoConection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private MongoConection mongoConection;

    public UserService(MongoConection mongoConection) {
        this.mongoConection = mongoConection;
    }

    public User criarUsuario(User user) {
        mongoConection.createUser(user);
        return user;
    }
}
