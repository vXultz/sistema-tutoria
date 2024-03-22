package com.senai.projetotutoria.controller;

import com.senai.projetotutoria.dto.TutorFiltro;
import com.senai.projetotutoria.entity.TutorEntity;
import com.senai.projetotutoria.service.TutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")
public class TutorController {
    
    private final TutorService service;


    public TutorController(TutorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TutorEntity>> get(TutorFiltro filtro) {
        List<TutorEntity> tutores = service.listarTutores(filtro);
        return ResponseEntity.status(HttpStatus.OK).body(tutores);
    }

    @GetMapping("{id}")
    public TutorEntity getId(@PathVariable Long id) throws Exception {
        return service.buscarTutorPorId(id);
    }

    @PostMapping
    public ResponseEntity<TutorEntity> post(@RequestBody TutorEntity tutor) throws Exception {
        TutorEntity tutores = service.criarTutor(tutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(tutores);
    }

    @PutMapping("{id}")
    public ResponseEntity<TutorEntity> post(@PathVariable Long id, @RequestBody TutorEntity tutor) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarTutor(id, tutor));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        service.deletarTutor(id);
        return ResponseEntity.noContent().build();
    }
}
