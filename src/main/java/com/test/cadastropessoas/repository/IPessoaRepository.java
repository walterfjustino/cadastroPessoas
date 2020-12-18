package com.test.cadastropessoas.repository;

import com.test.cadastropessoas.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPessoaRepository extends JpaRepository<PessoaEntity, Long> {

    @Query("Select p from PessoaEntity p where p.telefone = :telefone")
    public List<PessoaEntity> findByNomeTel(@Param("telefone") String telefone);
}
