package com.devinhouse.restapi.controllers;

import com.devinhouse.restapi.dtos.perguntaDtos.PerguntaRequest;
import com.devinhouse.restapi.dtos.perguntaDtos.PerguntaResponse;
import com.devinhouse.restapi.services.PerguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/perguntas")
public class PerguntaController {
    @Autowired
    PerguntaService service;

    @GetMapping
    public ResponseEntity<List<PerguntaResponse>> getPerguntas() {
        return ResponseEntity.ok(service.getPerguntas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerguntaResponse> getPerguntaById(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getPerguntaById(id));
    }

    @PostMapping
    public ResponseEntity<PerguntaResponse> criarPergunta(
            @RequestBody PerguntaRequest request,
            UriComponentsBuilder uriBuilder) {
        PerguntaResponse pergunta = service.criarPergunta(request);

        URI uri = uriBuilder.path("/perguntas/{id}")
                .buildAndExpand(pergunta.getId()).toUri();

        return ResponseEntity
                .created(uri)
                .body(pergunta);
    }
}
