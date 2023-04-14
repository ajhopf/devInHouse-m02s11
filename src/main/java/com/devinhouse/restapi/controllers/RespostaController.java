package com.devinhouse.restapi.controllers;

import com.devinhouse.restapi.dtos.respostaDtos.RespostaRequest;
import com.devinhouse.restapi.dtos.respostaDtos.RespostaResponse;
import com.devinhouse.restapi.services.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/respostas")
public class RespostaController {
    @Autowired
    RespostaService service;

    @GetMapping
    public ResponseEntity<List<RespostaResponse>> getAllRespostas() {
        return ResponseEntity.ok(service.getAllRespostas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespostaResponse> getRespostaById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRespostaById(id));
    }

    @PostMapping
    public ResponseEntity<RespostaResponse> criarResposta(
            @RequestBody RespostaRequest request,
            UriComponentsBuilder uriBuilder) {
        RespostaResponse resposta = service.criarResposta(request);

        URI uri = uriBuilder.path("/respostas/{id}")
                .buildAndExpand(resposta.getId()).toUri();

        return ResponseEntity
                .created(uri)
                .body(resposta);
    }
}
