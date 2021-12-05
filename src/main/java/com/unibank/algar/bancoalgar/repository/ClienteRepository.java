package com.unibank.algar.bancoalgar.repository;

import com.unibank.algar.bancoalgar.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("select saldo from Cliente where id = ?1")
    public Double findSaldoById(Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Cliente set saldo = saldo + ?2 where id = ?1")
    public void fazerDeposito(Long id, Double saldo);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Cliente set saldo = saldo - ?2 where id = ?1")
    public void fazerSaque(Long id, Double saldo);
}
