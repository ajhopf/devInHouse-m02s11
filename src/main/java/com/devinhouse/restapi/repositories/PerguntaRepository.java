package com.devinhouse.restapi.repositories;

import com.devinhouse.restapi.models.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {
    @Query("SELECT p FROM Pergunta p WHERE p.id_quiz = :id_quiz")
    List<Pergunta> findById_quiz(Long id_quiz);
}
