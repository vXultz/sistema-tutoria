package com.senai.projetotutoria.service;

import com.senai.projetotutoria.dto.TutorFiltro;
import com.senai.projetotutoria.entity.TutorEntity;

import java.util.List;

public interface TutorService {

    List<TutorEntity> listarTutores(TutorFiltro filtro);

    TutorEntity buscarTutorPorId(Long id) throws Exception;

    TutorEntity criarTutor(TutorEntity tutor) throws Exception;

    TutorEntity atualizarTutor(Long id, TutorEntity tutor) throws Exception;

    void deletarTutor(Long id) throws Exception;
}
