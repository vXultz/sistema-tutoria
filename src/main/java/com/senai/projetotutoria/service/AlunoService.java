package com.senai.projetotutoria.service;

import com.senai.projetotutoria.dto.AlunoFiltro;
import com.senai.projetotutoria.entity.AlunoEntity;

import java.util.List;

public interface AlunoService {

    List<AlunoEntity> listarAlunos(AlunoFiltro filtro);

    AlunoEntity buscarAlunoPorId(Long id) throws Exception;

    AlunoEntity criarAluno(AlunoEntity aluno) throws Exception;

    AlunoEntity atualizarAluno(Long id, AlunoEntity aluno) throws Exception;

    void deletarAluno(Long id) throws Exception;
}
