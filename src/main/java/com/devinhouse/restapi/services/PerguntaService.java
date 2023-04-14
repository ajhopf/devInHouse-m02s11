package com.devinhouse.restapi.services;

import com.devinhouse.restapi.dtos.perguntaDtos.PerguntaCompletoDto;
import com.devinhouse.restapi.dtos.perguntaDtos.PerguntaGetRequest;
import com.devinhouse.restapi.dtos.perguntaDtos.PerguntaRequest;
import com.devinhouse.restapi.mappers.PerguntaMapper;
import com.devinhouse.restapi.models.Pergunta;
import com.devinhouse.restapi.repositories.PerguntaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerguntaService {
    @Autowired
    private PerguntaRepository repository;

    @Autowired
    private PerguntaMapper mapper;

    public List<PerguntaCompletoDto> getPerguntas(
            PerguntaGetRequest requestParams
    ) {
        if (requestParams.getId_quiz() == null) {
            return mapper.map(repository.findAll());
        } else {
            return mapper.map(repository.findById_quiz(requestParams.getId_quiz()));
        }
    }

    public PerguntaCompletoDto getPerguntaById(Long id) {
        return mapper.map(repository.getReferenceById(id));
    }

    public PerguntaCompletoDto criarPergunta(PerguntaRequest perguntaRequest) {
        Pergunta pergunta = repository.save(mapper.map(perguntaRequest));

        return mapper.map(pergunta);
    }

    public PerguntaCompletoDto atualizarPergunta(PerguntaCompletoDto request) {
        Pergunta pergunta = repository.findById(request.getId())
                .orElseThrow(EntityNotFoundException::new);

        if (request.getTitulo() != null && request.getTitulo().length() > 0) {
            pergunta.setTitulo(request.getTitulo());
        }
        if (request.getTexto() != null && request.getTexto().length() > 0) {
            pergunta.setTexto(request.getTexto());
        }
        if(request.getId_quiz() != null) {
            pergunta.setId_quiz(request.getId_quiz());
        }

        repository.save(pergunta);

        return mapper.map(pergunta);
    }
}
