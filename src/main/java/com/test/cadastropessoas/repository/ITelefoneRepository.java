package com.test.cadastropessoas.repository;

import com.test.cadastropessoas.entity.TelefoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface ITelefoneRepository extends JpaRepository<TelefoneEntity, Long> {


}
