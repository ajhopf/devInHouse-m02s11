package com.devinhouse.restapi.services;

import com.devinhouse.restapi.dtos.perguntaDtos.PerguntaRequest;
import com.devinhouse.restapi.dtos.perguntaDtos.PerguntaResponse;
import com.devinhouse.restapi.mappers.PerguntaMapper;
import com.devinhouse.restapi.models.Pergunta;
import com.devinhouse.restapi.repositories.PerguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerguntaService {
    @Autowired
    private PerguntaRepository repository;

    @Autowired
    private PerguntaMapper mapper;

    public List<PerguntaResponse> getPerguntas() {

        return mapper.map(repository.findAll());
    }

    public PerguntaResponse getPerguntaById(Long id) {
        return mapper.map(repository.getReferenceById(id));
    }

    public PerguntaResponse criarPergunta(PerguntaRequest perguntaRequest) {
        Pergunta pergunta = repository.save(mapper.map(perguntaRequest));

        return mapper.map(pergunta);
    }

}
