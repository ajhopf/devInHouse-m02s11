package com.devinhouse.restapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "respostas")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;
    private Long id_pergunta;
}
