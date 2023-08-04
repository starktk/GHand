package com.example.GHand.repository;

import com.example.GHand.document.User;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;


public class MongoConection {

        @Value("${mongo-external-api}")
        private String uri;

        MongoClient ghand = new MongoClient(uri);
        MongoDatabase databaseGHand = ghand.getDatabase("GHand");
        MongoCollection<Document> collectionUser = databaseGHand.getCollection("user");


        public User createUser(User user) {
            collectionUser.insertOne(new Document()
                    .append("name", user.getName())
                    .append("password", user.getPassword()));
            return user;
        }
}
