package com.senai.projetotutoria.controller;

import com.senai.projetotutoria.dto.MaterialFiltro;
import com.senai.projetotutoria.entity.MaterialEntity;
import com.senai.projetotutoria.service.MaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("materiais")
public class MaterialController {
    
    private final MaterialService service;

    public MaterialController(MaterialService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MaterialEntity>> get(MaterialFiltro filtro) {
        List<MaterialEntity> materiais = service.listarMateriais(filtro);
        return ResponseEntity.status(HttpStatus.OK).body(materiais);
    }

    @GetMapping("{id}")
    public MaterialEntity getId(@PathVariable Long id) throws Exception {
        return service.buscarMaterialPorId(id);
    }

    @PostMapping
    public ResponseEntity<MaterialEntity> post(@RequestBody MaterialEntity material) throws Exception {
        MaterialEntity materiais = service.criarMaterial(material);
        return ResponseEntity.status(HttpStatus.CREATED).body(materiais);
    }

    @PutMapping("{id}")
    public ResponseEntity<MaterialEntity> post(@PathVariable Long id, @RequestBody MaterialEntity material) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarMaterial(id, material));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        service.deletarMaterial(id);
        return ResponseEntity.noContent().build();
    }
}
