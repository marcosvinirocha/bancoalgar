package com.unibank.algar.bancoalgar.repository;

import java.util.List;

import com.unibank.algar.bancoalgar.entity.Transacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    @Query(value = "SELECT * FROM Transacao WHERE conta_id = ?1", nativeQuery = true)
    List<Transacao> findByContaId(Long contaId);
}
