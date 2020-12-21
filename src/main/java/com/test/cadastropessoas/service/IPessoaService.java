package com.test.cadastropessoas.service;

import com.test.cadastropessoas.dto.PessoaDTO;


import java.util.List;

public interface IPessoaService {

    //LISTAR TODAS AS PESSOAS
    public List<PessoaDTO> listar();

    //CONSULTAR UMA PESSOA PELO ID
    public PessoaDTO consultar(final Long id);

    //CADASTRAR UMA PESSOA
    public Boolean cadastrar(final PessoaDTO pessoa);

    //ATUALIZAR UMA PESSOA
    public Boolean atualizar(final PessoaDTO pessoa);

    //EXCLUIR UMA PESSOA
    public Boolean excluir(final Long id);

}
