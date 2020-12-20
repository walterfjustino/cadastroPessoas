package com.test.cadastropessoas.repository;

import com.test.cadastropessoas.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface IEnderecoRepository extends JpaRepository<EnderecoEntity, Long> {

    @Query("Select e from EnderecoEntity e where e.nomeRua = :nomeRua")
    public EnderecoEntity findByEndereco(@Param("nomeRua")String nomeRua);
}
