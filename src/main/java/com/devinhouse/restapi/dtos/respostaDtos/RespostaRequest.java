package com.devinhouse.restapi.dtos.respostaDtos;

public class RespostaRequest {
    private String texto;
    private Long id_pergunta;

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
