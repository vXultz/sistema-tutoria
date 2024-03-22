package com.senai.projetotutoria.service;

import com.senai.projetotutoria.dto.AgendaFiltro;
import com.senai.projetotutoria.entity.AgendaEntity;

import java.util.List;

public interface AgendaService {

    List<AgendaEntity> listarAgendas(AgendaFiltro filtro);

    AgendaEntity buscarAgendaPorId(Long id) throws Exception;

    AgendaEntity criarAgenda(AgendaEntity agenda) throws Exception;

    AgendaEntity atualizarAgenda(Long id, AgendaEntity agenda) throws Exception;

    void deletarAgenda(Long id) throws Exception;
}
