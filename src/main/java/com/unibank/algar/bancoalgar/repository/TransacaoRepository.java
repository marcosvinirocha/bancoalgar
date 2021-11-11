package com.unibank.algar.bancoalgar.repository;

import com.unibank.algar.bancoalgar.entity.Transacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
