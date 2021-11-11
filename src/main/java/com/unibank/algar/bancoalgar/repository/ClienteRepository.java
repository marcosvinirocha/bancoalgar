package com.unibank.algar.bancoalgar.repository;

import com.unibank.algar.bancoalgar.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
