package com.unibank.algar.bancoalgar.controller.dto;

import com.unibank.algar.bancoalgar.entity.Cliente;

public class ClienteDto {
    private Long id;
    private String agencia;
    private String numeroConta;
    private Double saldo;

    public ClienteDto() {
    }

    public ClienteDto(Cliente cliente) {
        this.id = cliente.getId();
        this.agencia = cliente.getAgencia();
        this.numeroConta = cliente.getNumeroConta();
        this.saldo = cliente.getSaldo();
    }

    public Long getId() {
        return id;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

}
