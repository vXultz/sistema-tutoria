package com.senai.projetotutoria.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "agendas")
@Data
public class AgendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private AlunoEntity aluno;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private TutorEntity tutor;

    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private Status status;
    private String tema;
    private String descricao;
}
