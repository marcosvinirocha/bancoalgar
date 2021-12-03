package com.unibank.algar.bancoalgar.service;

import com.unibank.algar.bancoalgar.entity.Cliente;
import com.unibank.algar.bancoalgar.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarConta(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente clienteInfo(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Double getSaldo(Long id) {

        return clienteRepository.findSaldoById(id);
    }

    public void depositar(Long id, Double valor) {
        clienteRepository.salvarSaldo(id, valor);
    }

    public void sacar(Long id, Double valor) {
        clienteRepository.fazerDeposito(id, valor);
    }

    public void transferirDinheiro(Long id, Double valor, Long idDestino) {
        clienteRepository.fazerDeposito(id, valor);
        clienteRepository.salvarSaldo(idDestino, valor);
    }
}
