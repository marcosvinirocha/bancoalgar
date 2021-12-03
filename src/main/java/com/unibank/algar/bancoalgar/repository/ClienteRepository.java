package com.unibank.algar.bancoalgar.repository;

import com.unibank.algar.bancoalgar.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>, JpaRepository<Cliente, Long> {

    @Query("select saldo from Cliente where id = ?1")
    public Double findSaldoById(Long id);

    @Transactional
    @Query("update Cliente set saldo = saldo + ?2 where id = ?1")
    public void salvarSaldo(Long id, Double saldo);

    @Transactional
    @Query("update Cliente set saldo = saldo - ?2 where id = ?1")
    public void fazerDeposito(Long id, Double saldo);

}
