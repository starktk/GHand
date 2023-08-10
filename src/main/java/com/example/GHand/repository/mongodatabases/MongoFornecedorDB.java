package com.example.GHand.repository.mongodatabases;

import com.example.GHand.document.Fornecedor;

import java.util.List;

public class MongoFornecedorDB {


    private final MongoConect mongoConect;

    public MongoFornecedorDB(MongoConect mongoConect) {
        this.mongoConect = mongoConect;
    }

    public List<Fornecedor> addFornecedor(Fornecedor fornecedor) {
        fornecedor.getFornecedores().add(fornecedor);
        return fornecedor.getFornecedores();
    }
}
