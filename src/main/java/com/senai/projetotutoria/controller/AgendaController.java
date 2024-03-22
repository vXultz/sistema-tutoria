package com.senai.projetotutoria.controller;

import com.senai.projetotutoria.dto.AgendaFiltro;
import com.senai.projetotutoria.entity.AgendaEntity;
import com.senai.projetotutoria.service.AgendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendas")
public class AgendaController {

    private final AgendaService service;

    public AgendaController(AgendaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AgendaEntity>> get(AgendaFiltro filtro) {
        List<AgendaEntity> agendas = service.listarAgendas(filtro);
        return ResponseEntity.status(HttpStatus.OK).body(agendas);
    }

    @GetMapping("{id}")
    public AgendaEntity getId(@PathVariable Long id) throws Exception {
        return service.buscarAgendaPorId(id);
    }

    @PostMapping
    public ResponseEntity<AgendaEntity> post(@RequestBody AgendaEntity agenda) throws Exception {
        AgendaEntity agendas = service.criarAgenda(agenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(agendas);
    }

    @PutMapping("{id}")
    public ResponseEntity<AgendaEntity> post(@PathVariable Long id, @RequestBody AgendaEntity agenda) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarAgenda(id, agenda));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        service.deletarAgenda(id);
        return ResponseEntity.noContent().build();
    }
}
