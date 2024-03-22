package com.senai.projetotutoria.repository;

import com.senai.projetotutoria.entity.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {

    List<AgendaEntity> findByAlunoNomeContainingIgnoreCase(String nomeAluno);

    List<AgendaEntity> findByTutorNomeContainingIgnoreCase(String nomeTutor);

}
