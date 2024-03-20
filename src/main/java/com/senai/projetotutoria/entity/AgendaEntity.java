package com.senai.projetotutoria.entity;

import jakarta.persistence.*;
import lombok.Data;

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

    private String data;

    private Status status;
    private String tema;
    private String descricao;
}
