package com.example.GHand.repository;

import com.example.GHand.document.User;
import com.example.GHand.dto.user.UserCreateDto;
import com.example.GHand.repository.mongobase.MongoConect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class MongoUserDB {

    private final MongoConect mongoConect;

    private ObjectMapper objectMapper;

    public MongoUserDB(MongoConect mongoConect) {
        this.mongoConect = mongoConect;
    }

    public User createUser(UserCreateDto userCreateDto) {
        mongoConect.pegarColection("user").insertOne(new Document()
                .append("name", userCreateDto.getName())
                .append("email", userCreateDto.getEmail())
                .append("password", userCreateDto.getPassword()));
        User user = objectMapper.convertValue(userCreateDto, User.class);
        return user;
    }
    public User findUser(String name) {
        Document search = mongoConect.pegarDocumento();
        search.put("name", name);
        FindIterable<Document> user = mongoConect.pegarColection("user").find(search);
        return objectMapper.convertValue(user, User.class);
    }

    public void deleteUser(String name, String password) {
        User user = findUser(name);
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Senha incorreta");
        }
        Document remove = mongoConect.pegarDocumento();
        remove.get(user.getPassword());
        mongoConect.pegarColection("user").deleteOne(remove);
    }
}
