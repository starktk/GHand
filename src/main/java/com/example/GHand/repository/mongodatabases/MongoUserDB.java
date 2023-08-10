package com.example.GHand.repository.mongodatabases;

import com.example.GHand.document.Usuario;
import com.example.GHand.dto.user.UserCreateDto;
import com.example.GHand.repository.MongoConnect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MongoUserDB implements MongoConnect {
    @Value("${mongo-external-api}")
    private String uri;

    private ObjectMapper objectMapper;
    @Override
    public MongoClient mongoGetConect() {
       return new MongoClient(uri);
    }

    @Override
    public MongoDatabase mongoGetDatabase(String database) {
        return mongoGetConect().getDatabase(database);
    }

    @Override
    public MongoCollection<Document> mongoGetCollection(String collection) {
        return mongoGetDatabase("user").getCollection(collection);
    }

    @Override
    public Document mongoGetDocument() {
        return new Document();
    }

    public Usuario createUser(UserCreateDto userCreateDto) {
        mongoGetCollection("user").insertOne(mongoGetDocument()
                .append("name", userCreateDto.getName())
                .append("email", userCreateDto.getEmail())
                .append("password", userCreateDto.getPassword()));
        Usuario usuario = objectMapper.convertValue(userCreateDto, Usuario.class);
        return usuario;
    }

    public Usuario findUser(String name) {
        Document search = mongoGetDocument();
        search.put("name", name);
        FindIterable<Document> user = mongoGetCollection("user").find(search);
        return objectMapper.convertValue(user, Usuario.class);
    }

    public void deleteUser(String name, String password) {
        Usuario user = findUser(name);
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Senha incorreta");
        }
        Document remove = mongoGetDocument();
        remove.get(user.getPassword());
        mongoGetCollection("user").deleteOne(remove);
    }

    public Usuario updatePassword(String name, String password) {
        Usuario user = findUser(name);
        if (user == null) {
            throw new RuntimeException("usuário inexistente");
        } else if (user.getPassword().equals(password)) {
            throw new RuntimeException("Senha incorreta");
        }
        UpdateResult userRetorno = mongoGetCollection("user").updateOne(Filters.eq("password", user.getPassword())
                , Updates.set("password", password));
        return objectMapper.convertValue(userRetorno, Usuario.class);
    }

    public Usuario updateUser(String name, String email) {
        Usuario user = findUser(name);
        if (user == null) {
            throw new RuntimeException("usuário inexistente");
        } else if (user.getName().equals(name) && user.getEmail().equals(email)) {
            throw new RuntimeException("Campos iguais não podem ser alterados");
        }
        UpdateResult userRetorno = mongoGetCollection("user").updateOne(Filters.eq("name", user.getName()),
                Updates.set("name", name), (UpdateOptions) Updates.set("email", email));
        return objectMapper.convertValue(userRetorno, Usuario.class);
    }
}
