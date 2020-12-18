package com.test.cadastropessoas.service;

import com.test.cadastropessoas.dto.EnderecoDTO;

import java.util.List;

public interface IEnderecoService {

    //LISTAR TODOS OS ENDERECOS
    public List<EnderecoDTO> listar();

    //CONSULTAR UM ENDEREÇO PELO ID
    public EnderecoDTO consultar(final Long id);

    //CADASTRAR UM ENDEREÇO
    public Boolean cadastrar(final EnderecoDTO endereco);

    //ATUALIZAR UM ENDEREÇO
    public Boolean atualizar(final EnderecoDTO endereco);

    //EXCLUIR UM ENDEREÇO
    public Boolean excluir(final Long id);
}
