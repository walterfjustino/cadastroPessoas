package com.test.cadastropessoas.repository;

import com.test.cadastropessoas.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnderecoRepository extends JpaRepository<EnderecoEntity, Long> {
}
