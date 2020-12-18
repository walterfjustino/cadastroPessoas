package com.test.cadastropessoas.service;

import com.test.cadastropessoas.dto.TelefoneDTO;

import java.util.List;

public interface ITelefoneService {

    //LISTAR TODOS OS TELEFONES
    public List<TelefoneDTO> listar();

    //CONSULTAR TELEFONE POR ID
    public TelefoneDTO consultar(final Long id);

    //CADASTRAR UM TELEFONE
    public Boolean cadastrar(final TelefoneDTO telefone);

    //ATUALIZAR UM TELEFONE
    public Boolean atualizar(final TelefoneDTO telefone);

    //EXCLUIR UM TELEFONE
    public Boolean excluir(final Long id);


}
