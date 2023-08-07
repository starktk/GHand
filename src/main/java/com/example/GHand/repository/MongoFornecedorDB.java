package com.example.GHand.repository;

import com.example.GHand.document.Fornecedor;
import com.example.GHand.repository.mongobase.MongoConect;

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
