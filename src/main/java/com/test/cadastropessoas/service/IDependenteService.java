package com.test.cadastropessoas.service;

import com.test.cadastropessoas.dto.DepedenteDTO;

import java.util.List;

public interface IDependenteService {

    //LISTAR TODOS OS DEPENDENTES
    public List<DepedenteDTO> listar();

    //CONSULTAR UM DEPENDENTE PELO ID
    public DepedenteDTO consultar(final Long id);

    //CADASTRAR UM DEPENDENTE
    public Boolean cadastrar(final DepedenteDTO dependente);

    //ATUALIZAR UM DEPENDENTE
    public Boolean atualizar(final DepedenteDTO dependente);

    //EXCLUIR UM DEPENDENTE
    public Boolean excluir(final Long id);

}
