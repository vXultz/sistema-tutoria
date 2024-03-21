package com.senai.projetotutoria.repository;

import com.senai.projetotutoria.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {

    List<AlunoEntity> findByNomeContainingIgnoreCase(String nome);
}
