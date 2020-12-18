package com.test.cadastropessoas.repository;

import com.test.cadastropessoas.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPessoaRepository extends JpaRepository<PessoaEntity, Long> {
}
