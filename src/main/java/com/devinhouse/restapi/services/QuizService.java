package com.devinhouse.restapi.services;

import com.devinhouse.restapi.dtos.quizDtos.QuizRequest;
import com.devinhouse.restapi.dtos.quizDtos.QuizResponse;
import com.devinhouse.restapi.mappers.QuizMapper;
import com.devinhouse.restapi.models.Quiz;
import com.devinhouse.restapi.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizRepository repository;
    @Autowired
    private QuizMapper mapper;

    public List<QuizResponse> getAllQuiz() {
        return mapper.map(repository.findAll());
    }

    public QuizResponse getQuizById(Long id) {
        Quiz quiz = repository.getReferenceById(id);

        return mapper.map(quiz);
    }

    public QuizResponse criarQuiz(QuizRequest request) {
        Quiz quiz = repository.save(mapper.map(request));

        return mapper.map(quiz);
    }

}
