package com.senai.projetotutoria.service;

import com.senai.projetotutoria.dto.MaterialFiltro;
import com.senai.projetotutoria.entity.MaterialEntity;

import java.util.List;

public interface MaterialService {
    
    List<MaterialEntity> listarMateriais(MaterialFiltro filtro);

    MaterialEntity buscarMaterialPorId(Long id) throws Exception;

    MaterialEntity criarMaterial(MaterialEntity material) throws Exception;

    MaterialEntity atualizarMaterial(Long id, MaterialEntity material) throws Exception;

    void deletarMaterial(Long id) throws Exception;
}
