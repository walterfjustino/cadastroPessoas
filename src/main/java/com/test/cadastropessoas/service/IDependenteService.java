package com.test.cadastropessoas.service;

import com.test.cadastropessoas.dto.DependenteDTO;

import java.util.List;

public interface IDependenteService {

    //LISTAR TODOS OS DEPENDENTES
    public List<DependenteDTO> listar();

    //CONSULTAR UM DEPENDENTE PELO ID
    public DependenteDTO consultar(final Long id);

    //CADASTRAR UM DEPENDENTE
    public Boolean cadastrar(final DependenteDTO dependente);

    //ATUALIZAR UM DEPENDENTE
    public Boolean atualizar(final DependenteDTO dependente);

    //EXCLUIR UM DEPENDENTE
    public Boolean excluir(final Long id);

}
