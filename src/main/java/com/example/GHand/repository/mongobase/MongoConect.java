package com.example.GHand.repository.mongobase;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

@Getter
public final class MongoConect {

    @Value("${mongo-external-api}")
    private String uri;

    private final MongoClient ghand = new MongoClient(uri);
    private final MongoDatabase databaseGHand = ghand.getDatabase("GHand");

    private MongoCollection<Document> collections;

    public MongoCollection<Document> pegarColection(String collection) {
        return collections = databaseGHand.getCollection(collection);
    }

    public Document pegarDocumento() {
        return new Document();
    }
}
