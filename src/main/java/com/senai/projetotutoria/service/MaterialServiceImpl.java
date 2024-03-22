package com.senai.projetotutoria.service;

import com.senai.projetotutoria.dto.MaterialFiltro;
import com.senai.projetotutoria.entity.MaterialEntity;
import com.senai.projetotutoria.exception.error.NotFoundException;
import com.senai.projetotutoria.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService{

    private final MaterialRepository materialRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public List<MaterialEntity> listarMateriais(MaterialFiltro filtro) {
        return materialRepository.findAll();
    }

    @Override
    public MaterialEntity buscarMaterialPorId(Long id) throws Exception {
        return materialRepository.findById(id).orElseThrow(() -> new NotFoundException("Material não encontrado."));
    }

    @Override
    public MaterialEntity criarMaterial(MaterialEntity material) throws Exception {
        material.setId(null);
        return materialRepository.save(material);
    }

    @Override
    public MaterialEntity atualizarMaterial(Long id, MaterialEntity material) throws Exception {
        MaterialEntity entity = buscarMaterialPorId(id);
        entity.setCaminhoArquivo(material.getCaminhoArquivo());
        return materialRepository.save(entity);
    }

    @Override
    public void deletarMaterial(Long id) throws Exception {
        MaterialEntity entity = buscarMaterialPorId(id);
        materialRepository.delete(entity);
    }
}
