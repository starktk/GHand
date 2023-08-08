package com.example.GHand.dto.fornecedor;


import com.example.GHand.document.Contato;
import com.example.GHand.document.Fornecedor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FornecedorDto {

    private String razaoSocial;

    private String cnpj;

    private Contato contato;

    private List<Fornecedor> fornecedores;
}
