package com.devinhouse.restapi.controllers;

import com.devinhouse.restapi.dtos.quizDtos.QuizCompletoDto;
import com.devinhouse.restapi.dtos.quizDtos.QuizRequest;
import com.devinhouse.restapi.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService service;

    @GetMapping
    public ResponseEntity<List<QuizCompletoDto>> getAllQuiz() {
        return ResponseEntity.ok(service.getAllQuiz());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizCompletoDto> getQuizById(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getQuizById(id));
    }

    @PostMapping
    public ResponseEntity<QuizCompletoDto> criarQuiz(
            @RequestBody QuizRequest request,
            UriComponentsBuilder uriBuilder) {
        QuizCompletoDto quiz = service.criarQuiz(request);

        URI uri = uriBuilder.path("/quiz/{id}")
                .buildAndExpand(quiz.getId()).toUri();

        return ResponseEntity
                .created(uri)
                .body(quiz);
    }

    @PutMapping
    public ResponseEntity<QuizCompletoDto> atualizarQuiz(
            @RequestBody QuizCompletoDto request
    ) {
        QuizCompletoDto quiz = service.atualizarQuiz(request);

        return ResponseEntity.ok(quiz);
    }
}
