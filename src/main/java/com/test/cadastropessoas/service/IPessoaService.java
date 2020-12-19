package com.test.cadastropessoas.service;

import com.test.cadastropessoas.dto.PessoaDTO;
import com.test.cadastropessoas.entity.PessoaEntity;

import java.util.List;

public interface IPessoaService {

    //LISTAR TODAS AS PESSOAS
    public List<PessoaDTO> listar();

    //LISTAR TODOS OS TELEFONES DE UMA PESSOA
    public List<PessoaEntity> findByNomeTel(String telefone);

    //CONSULTAR UMA PESSOA PELO ID
    public PessoaDTO consultar(final Long id);

    //CADASTRAR UMA PESSOA
    public Boolean cadastrar(final PessoaDTO pessoa);

    //ATUALIZAR UMA PESSOA
    public Boolean atualizar(final PessoaDTO pessoa);

    //EXCLUIR UMA PESSOA
    public Boolean excluir(final Long id);

}
