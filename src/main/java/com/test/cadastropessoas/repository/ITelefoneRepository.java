package com.test.cadastropessoas.repository;

import com.test.cadastropessoas.entity.DependenteEntity;
import com.test.cadastropessoas.entity.TelefoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface ITelefoneRepository extends JpaRepository<TelefoneEntity, Long> {

    @Query("Select t from TelefoneEntity t where t.numero = :numero")
    public TelefoneEntity findByNumero(@Param("numero")String numero);

}
