package com.unibank.algar.bancoalgar.service;

import com.unibank.algar.bancoalgar.entity.Cliente;
import com.unibank.algar.bancoalgar.entity.Transacao;
import com.unibank.algar.bancoalgar.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TransacaoService transacaoService;

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
        clienteRepository.fazerDeposito(id, valor);
    }

    public void sacar(Long id, Double valor) {
        clienteRepository.fazerSaque(id, valor);
    }

    public void transferirDinheiro(Long id, Long idDestino, Double valor) {
        clienteRepository.fazerSaque(id, valor);
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        Transacao transacao = new Transacao();
        transacao.setTipo("Transferencia");
        transacao.setValor(valor);
        transacao.setConta(cliente);
        transacaoService.salvarTransacao(transacao);
        clienteRepository.fazerDeposito(idDestino, valor);
        Cliente cliente2 = clienteRepository.findById(idDestino).orElse(null);
        Transacao transacao2 = new Transacao();
        transacao.setTipo("Transferencia");
        transacao.setValor(valor);
        transacao.setConta(cliente2);
        transacaoService.salvarTransacao(transacao2);
    }
}
