package com.senai.projetotutoria.repository;

import com.senai.projetotutoria.entity.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorRepository extends JpaRepository<TutorEntity, Long> {

    List<TutorEntity> findByNomeContainingIgnoreCase(String nome);
    List<TutorEntity> findByEspecialidadeContainingIgnoreCase(String especialidade);

}
