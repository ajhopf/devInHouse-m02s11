package com.devinhouse.restapi.services;

import com.devinhouse.restapi.dtos.quizDtos.QuizCompletoDto;
import com.devinhouse.restapi.dtos.quizDtos.QuizRequest;
import com.devinhouse.restapi.mappers.QuizMapper;
import com.devinhouse.restapi.models.Quiz;
import com.devinhouse.restapi.repositories.QuizRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizRepository repository;
    @Autowired
    private QuizMapper mapper;

    public List<QuizCompletoDto> getAllQuiz() {
        return mapper.map(repository.findAll());
    }

    public QuizCompletoDto getQuizById(Long id) {
        Quiz quiz = repository.getReferenceById(id);

        return mapper.map(quiz);
    }

    public QuizCompletoDto criarQuiz(QuizRequest request) {
        Quiz quiz = repository.save(mapper.map(request));

        return mapper.map(quiz);
    }

    public QuizCompletoDto atualizarQuiz(QuizCompletoDto request) {
        Quiz quiz = repository.findById(request.getId())
                .orElseThrow(EntityNotFoundException::new);

        if (request.getNome() != null && request.getNome().length() > 0) {
            quiz.setNome(request.getNome());
        }
        if (request.getDescricao() != null && request.getDescricao().length() > 0) {
            quiz.setDescricao(request.getDescricao());
        }

        repository.save(quiz);

        return mapper.map(quiz);
    }

    public void deletarQuiz(Long id) {
        repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        repository.deleteById(id);
    }
}
