package com.senai.projetotutoria.repository;

import com.senai.projetotutoria.entity.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {

    List<AgendaEntity> findByAlunoNomeContainingIgnoreCase(String nomeAluno);

    List<AgendaEntity> findByTutorNomeContainingIgnoreCase(String nomeTutor);

    List<AgendaEntity> findByAlunoIdOrderByData(Long id);

    List<AgendaEntity> findByAlunoIdAndDataAfterOrderByData(Long id, LocalDate data);

    List<AgendaEntity> findByTutorIdOrderByData(Long id);

    List<AgendaEntity> findByTutorIdAndDataAfterOrderByData(Long id, LocalDate data);
}
