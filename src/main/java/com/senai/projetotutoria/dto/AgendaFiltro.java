package com.senai.projetotutoria.dto;

import com.senai.projetotutoria.entity.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AgendaFiltro {

    private String alunoNome;
    private String tutorNome;
    private LocalDate data;
    private Status statusStatus;

}
