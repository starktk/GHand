package com.example.GHand.repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Repository;


@Repository
public interface MongoConnect {

    MongoClient mongoGetConect();

    MongoDatabase mongoGetDatabase(String database);

    MongoCollection<Document> mongoGetCollection(String collection);

    Document mongoGetDocument();
}
