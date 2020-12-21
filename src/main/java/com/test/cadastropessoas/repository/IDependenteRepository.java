package com.test.cadastropessoas.repository;

import com.test.cadastropessoas.entity.DependenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface IDependenteRepository extends JpaRepository<DependenteEntity, Long> {

    @Query("Select d from DependenteEntity d where d.nome = :nome")
    public DependenteEntity findByNomeDependente(@Param("nome")String nome);

}
