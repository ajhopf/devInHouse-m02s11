package com.devinhouse.restapi.repositories;

import com.devinhouse.restapi.models.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {
}
