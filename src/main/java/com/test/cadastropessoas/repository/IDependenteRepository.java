package com.test.cadastropessoas.repository;

import com.test.cadastropessoas.entity.DependenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IDependenteRepository extends JpaRepository<DependenteEntity, Long> {
}
