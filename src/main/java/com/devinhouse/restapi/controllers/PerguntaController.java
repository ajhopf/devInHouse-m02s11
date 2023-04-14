package com.devinhouse.restapi.controllers;

import com.devinhouse.restapi.dtos.perguntaDtos.PerguntaResponse;
import com.devinhouse.restapi.services.PerguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/perguntas")
public class PerguntaController {
    @Autowired
    PerguntaService service;

    @GetMapping
    public List<PerguntaResponse> getPerguntas() {
        return service.getPerguntas();
    }
}
