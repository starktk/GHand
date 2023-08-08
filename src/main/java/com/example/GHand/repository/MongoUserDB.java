package com.example.GHand.repository;

import com.example.GHand.document.Usuario;
import com.example.GHand.dto.user.UserCreateDto;
import com.example.GHand.repository.mongobase.MongoConect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

public class MongoUserDB {

    private final MongoConect mongoConect;

    private ObjectMapper objectMapper;

    public MongoUserDB(MongoConect mongoConect) {
        this.mongoConect = mongoConect;
    }

    public Usuario createUser(UserCreateDto userCreateDto) {
        mongoConect.pegarColection("user").insertOne(new Document()
                .append("name", userCreateDto.getName())
                .append("email", userCreateDto.getEmail())
                .append("password", userCreateDto.getPassword()));
        Usuario user = objectMapper.convertValue(userCreateDto, Usuario.class);
        return user;
    }

    public Usuario findUser(String name) {
        Document search = mongoConect.pegarDocumento();
        search.put("name", name);
        FindIterable<Document> user = mongoConect.pegarColection("user").find(search);
        return objectMapper.convertValue(user, Usuario.class);
    }

    public void deleteUser(String name, String password) {
        Usuario user = findUser(name);
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Senha incorreta");
        }
        Document remove = mongoConect.pegarDocumento();
        remove.get(user.getPassword());
        mongoConect.pegarColection("user").deleteOne(remove);
    }

    public Usuario updatePassword(String name, String password) {
        Usuario user = findUser(name);
        if (user.getPassword().equals(password)) {
            throw new RuntimeException("Senha incorreta");
        }
        UpdateResult userRetorno = mongoConect.pegarColection("user").updateOne(Filters.eq("password", user.getPassword())
                , Updates.set("password", password));
        return objectMapper.convertValue(userRetorno, Usuario.class);
    }


 //   public Usuario updateUser(String name, String email, String password) {
 //       Usuario user = findUser(name);
 //       if (user.getName().equals(name) && user.getEmail().equals(email) && user.getPassword().equals(password)) {
 //           throw new RuntimeException("Usuario inexistente");
        }
        //      Document doc = mongoConect.pegarDocumento();
        //      doc.append("name", name)
        //              .append("email", email)
        //                .append("password", password);
        //       UpdateResult userRetorno = mongoConect.pegarColection("user")
        //               .updateOne(Filters.eq("name", user.getName()), Updates.set("name", name));
 //   }


