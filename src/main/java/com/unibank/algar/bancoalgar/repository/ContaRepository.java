package com.unibank.algar.bancoalgar.repository;

import com.unibank.algar.bancoalgar.entity.Conta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}
