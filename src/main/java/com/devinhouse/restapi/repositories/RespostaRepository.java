package com.devinhouse.restapi.repositories;

import com.devinhouse.restapi.models.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {
    @Query("SELECT r FROM Resposta r WHERE r.id_pergunta = :idpergunta")
    List<Resposta> findByPerguntaId(Long idpergunta);
}
