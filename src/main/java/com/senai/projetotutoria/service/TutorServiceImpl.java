package com.senai.projetotutoria.service;

import com.senai.projetotutoria.dto.TutorFiltro;
import com.senai.projetotutoria.entity.TutorEntity;
import com.senai.projetotutoria.exception.error.NotFoundException;
import com.senai.projetotutoria.repository.TutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class TutorServiceImpl implements TutorService{
    private final TutorRepository tutorRepository;

    public TutorServiceImpl(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @Override
    public List<TutorEntity> listarTutors(TutorFiltro filtro) {
        if (StringUtils.hasText(filtro.getNome()) && StringUtils.hasText(filtro.getEspecialidade())) {
            return tutorRepository.findByNomeContainingIgnoreCase(filtro.getNome());
        } else if (StringUtils.hasText(filtro.getEspecialidade())) {
            return tutorRepository.findByEspecialidadeContainingIgnoreCase(filtro.getEspecialidade());
        }
        return tutorRepository.findAll();
    }

    @Override
    public TutorEntity buscarTutorPorId(Long id) {
        return tutorRepository.findById(id).orElseThrow(() -> new NotFoundException("Tutor não encontrado."));
    }

    @Override
    public TutorEntity criarTutor(TutorEntity tutor) {
        tutor.setId(null);
        return tutorRepository.save(tutor);
    }

    @Override
    public TutorEntity atualizarTutor(Long id, TutorEntity tutor) {
        TutorEntity entity = buscarTutorPorId(id);
        entity.setNome(tutor.getNome());
        entity.setEspecialidade(tutor.getEspecialidade());
        return tutorRepository.save(entity);
    }

    @Override
    public void deletarTutor(Long id) {
        TutorEntity entity = buscarTutorPorId(id);
        tutorRepository.delete(entity);
    }
}
