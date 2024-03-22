package com.senai.projetotutoria.service;

import com.senai.projetotutoria.dto.AlunoFiltro;
import com.senai.projetotutoria.entity.AlunoEntity;
import com.senai.projetotutoria.exception.error.NotFoundException;
import com.senai.projetotutoria.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService{

    private final AlunoRepository alunoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<AlunoEntity> listarAlunos(AlunoFiltro filtro) {
        if (StringUtils.hasText(filtro.getNome())) {
            return alunoRepository.findByNomeContainingIgnoreCase(filtro.getNome());
        }
        return alunoRepository.findAll();
    }

    @Override
    public AlunoEntity buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id).orElseThrow(() -> new NotFoundException("Aluno não encontrado."));
    }

    @Override
    public AlunoEntity criarAluno(AlunoEntity aluno) {
        aluno.setId(null);
        return alunoRepository.save(aluno);
    }

    @Override
    public AlunoEntity atualizarAluno(Long id, AlunoEntity aluno) {
        AlunoEntity entity = buscarAlunoPorId(id);
        entity.setNome(aluno.getNome());
        return alunoRepository.save(entity);
    }

    @Override
    public void deletarAluno(Long id) {
        AlunoEntity entity = buscarAlunoPorId(id);
        alunoRepository.delete(entity);
    }
}
