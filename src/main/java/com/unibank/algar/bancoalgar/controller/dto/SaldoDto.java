package com.unibank.algar.bancoalgar.controller.dto;

import com.unibank.algar.bancoalgar.entity.Cliente;

public class SaldoDto {
    private String agencia;
    private String conta;
    private Double valor;

    public SaldoDto(Cliente cliente, Double valor) {
        this.agencia = cliente.getAgencia();
        this.conta = cliente.getNumeroConta();
        this.valor = cliente.getSaldo();
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return this.conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

}
