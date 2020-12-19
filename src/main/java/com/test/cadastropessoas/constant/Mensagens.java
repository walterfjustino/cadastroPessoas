package com.test.cadastropessoas.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Mensagens {

    ERRO_GENERICO("Erro interno identificado. Contate o suporte."),
    ERRO_PESSOA_NAO_ENCONTRADA("Pessoa não Encontrada!"),
    ERRO_ENDERECO_NAO_ENCONTRADO("Endereço não encontrado!"),
    ERRO_TELEFONE_NAO_ENCONTRADO("Telefone não encontrado!"),
    ERRO_DEPENDENTE_NAO_ENCONTRADO("Dependente não encontrado!"),
    ERRO_PESSOA_CADASTRADA("Pessoa já cadastrada!"),
    ERRO_ENDERECO_CADASTRADO("Endereco já cadastrado!"),
    ERRO_TELEFONE_CADASTRADO("Telefone já cadastrado!"),
    ERRO_DEPENDENTE_CADASTRADO("Dependente já cadastrado!"),
    ERRO_ID_INFORMADO("ID não pode ser informado na operação de cadastro.");

    private final String valor;


}
