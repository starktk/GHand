package com.example.GHand.dto.fornecedor;

import com.example.GHand.document.Contato;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FornecedorCreateDto {

    private String razaoSocial;

    private String cnpj;

    private Contato contato;

}
