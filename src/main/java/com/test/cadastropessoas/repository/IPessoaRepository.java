package com.test.cadastropessoas.repository;

import com.test.cadastropessoas.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;




@Repository
public interface IPessoaRepository extends JpaRepository<PessoaEntity, Long> {


    @Query("Select p from PessoaEntity p where p.nome = :nome")
    public PessoaEntity findByNome(@Param("nome")String nome);
}
