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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getId_pergunta() {
        return id_pergunta;
    }

    public void setId_pergunta(Long id_pergunta) {
        this.id_pergunta = id_pergunta;
    }
}
