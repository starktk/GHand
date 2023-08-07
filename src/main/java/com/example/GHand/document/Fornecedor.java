package com.example.GHand.document;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class Fornecedor {

    private String razaoSocial;

    private String cnpj;

    private String contato;

    private List<Fornecedor> fornecedores;


}
