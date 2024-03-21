package com.senai.projetotutoria.controller;

import com.senai.projetotutoria.dto.AlunoFiltro;
import com.senai.projetotutoria.entity.AlunoEntity;
import com.senai.projetotutoria.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AlunoEntity>> get(AlunoFiltro filtro) {
        List<AlunoEntity> alunos = service.listarAlunos(filtro);
        return ResponseEntity.status(HttpStatus.OK).body(alunos);
    }

    @GetMapping("{id}")
    public AlunoEntity getId(@PathVariable Long id) throws Exception {
        return service.buscarAlunoPorId(id);
    }

    @PostMapping
    public ResponseEntity<AlunoEntity> post(@RequestBody AlunoEntity aluno) throws Exception {
        AlunoEntity alunos = service.criarAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunos);
    }

    @PutMapping("{id}")
    public ResponseEntity<AlunoEntity> post(@PathVariable Long id, @RequestBody AlunoEntity aluno) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarAluno(id, aluno));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        service.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }
}
