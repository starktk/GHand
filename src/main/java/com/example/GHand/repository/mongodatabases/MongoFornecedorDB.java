package com.example.GHand.repository.mongodatabases;

import com.example.GHand.document.Fornecedor;
import com.example.GHand.repository.MongoConnect;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

public class MongoFornecedorDB implements MongoConnect {




    public List<Fornecedor> addFornecedor(Fornecedor fornecedor) {
        fornecedor.getFornecedores().add(fornecedor);
        return fornecedor.getFornecedores();
    }

    @Override
    public MongoClient mongoGetConect() {
        return null;
    }

    @Override
    public MongoDatabase mongoGetDatabase(String database) {
        return null;
    }

    @Override
    public MongoCollection<Document> mongoGetCollection(String collection) {
        return null;
    }

    @Override
    public Document mongoGetDocument() {
        return null;
    }
}
