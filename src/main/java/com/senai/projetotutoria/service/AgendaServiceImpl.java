package com.senai.projetotutoria.service;

import com.senai.projetotutoria.dto.AgendaFiltro;
import com.senai.projetotutoria.entity.AgendaEntity;
import com.senai.projetotutoria.exception.error.NotFoundException;
import com.senai.projetotutoria.repository.AgendaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository agendaRepository;

    public AgendaServiceImpl(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }


    @Override
    public List<AgendaEntity> listarAgendas(AgendaFiltro filtro) {
        if (StringUtils.hasText(filtro.getAlunoNome())) {
            return agendaRepository.findByAlunoNomeContainingIgnoreCase(filtro.getAlunoNome());
        } else if (StringUtils.hasText(filtro.getTutorNome())) {
            return agendaRepository.findByTutorNomeContainingIgnoreCase(filtro.getTutorNome());
        }
        return agendaRepository.findAll();
    }

    @Override
    public AgendaEntity buscarAgendaPorId(Long id) {
        return agendaRepository.findById(id).orElseThrow(() -> new NotFoundException("Agendamento não encontrado."));
    }

    @Override
    public List<AgendaEntity> buscarAgendaPorAlunoId(Long id) {
        List<AgendaEntity> agendas = agendaRepository.findByAlunoIdOrderByData(id);
        if (agendas.isEmpty()) {
            throw new NotFoundException("Nenhuma agenda com este ID de aluno encontrada");
        }
        return agendas;
    }

    @Override
    public List<AgendaEntity> buscarAgendaPorTutorId(Long id) throws Exception {
        List<AgendaEntity> agendas = agendaRepository.findByTutorIdOrderByData(id);
        if (agendas.isEmpty()) {
            throw new NotFoundException("Nenhuma agenda com este ID de tutor encontrada");
        }
        return agendas;
    }

    @Override
    public AgendaEntity criarAgenda(AgendaEntity agenda) {
        agenda.setId(null);
        return agendaRepository.save(agenda);
    }

    @Override
    public AgendaEntity atualizarAgenda(Long id, AgendaEntity agenda) {
        AgendaEntity entity = buscarAgendaPorId(id);
        entity.setAluno(agenda.getAluno());
        entity.setTutor(agenda.getTutor());
        entity.setData(agenda.getData());
        entity.setStatus(agenda.getStatus());
        entity.setTema(agenda.getTema());
        entity.setDescricao(agenda.getDescricao());
        return agendaRepository.save(entity);
    }

    @Override
    public void deletarAgenda(Long id) {
        AgendaEntity entity = buscarAgendaPorId(id);
        agendaRepository.delete(entity);
    }
}
