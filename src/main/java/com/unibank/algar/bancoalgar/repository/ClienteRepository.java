package com.unibank.algar.bancoalgar.repository;

import com.unibank.algar.bancoalgar.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // @Query(value = "select c.agencia,c.numeroConta,c.saldo from Cliente c where
    // c.id = :id")
    // Cliente mostrarSaldo(Long id);
}
