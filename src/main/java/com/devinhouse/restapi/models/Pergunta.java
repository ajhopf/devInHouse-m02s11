package com.devinhouse.restapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "perguntas")
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String texto;
    private Long id_quiz;
}
