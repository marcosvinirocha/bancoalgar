package com.unibank.algar.bancoalgar.controller;

import java.util.List;

import com.unibank.algar.bancoalgar.entity.Cliente;
import com.unibank.algar.bancoalgar.entity.Transacao;
import com.unibank.algar.bancoalgar.service.ClienteService;
import com.unibank.algar.bancoalgar.service.TransacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private TransacaoService transacaoService;

    // Todo: criar conta
    @PostMapping("/abrir-conta")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Cliente abrirConta(@RequestBody Cliente cliente) {
        return clienteService.criarConta(cliente);
    }

    @GetMapping("/conta/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Cliente getInfoCliente(@PathVariable Long id) {
        return clienteService.clienteInfo(id);
    }

    // Todo:Mostrar saldo do cliente
    @GetMapping("/{id}/saldo")
    @ResponseStatus(value = HttpStatus.OK)
    public Double mostrarSaldo(@PathVariable Long id) {
        return clienteService.getSaldo(id);
    }

    // todo: fazer o deposito do cliente
    @PutMapping("/conta/{id}/deposito/{valor}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> fazerDeposito(@PathVariable Long id, @PathVariable Double valor) {
        Double initialSaldo = clienteService.getSaldo(id);
        clienteService.depositar(id, valor);
        Cliente cliente = clienteService.clienteInfo(id);
        Transacao transacao = new Transacao();
        transacao.setTipo("Deposito");
        transacao.setValor(valor);
        transacao.setConta(cliente);
        transacaoService.salvarTransacao(transacao);
        return ResponseEntity.ok().body("Deposito realizado com sucesso. Saldo anterior: " + initialSaldo
                + " Saldo atual: " + clienteService.getSaldo(id));
    }

    // todo: fazer o saque do cliente
    @PutMapping("/conta/{id}/saque/{valor}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> fazerSaque(@PathVariable Long id, @PathVariable Double valor) {
        Double initialSaldo = clienteService.getSaldo(id);
        clienteService.sacar(id, valor);
        Cliente cliente = clienteService.clienteInfo(id);
        Transacao transacao = new Transacao();
        transacao.setTipo("Saque");
        transacao.setValor(valor);
        transacao.setConta(cliente);
        transacaoService.salvarTransacao(transacao);
        return ResponseEntity.ok().body("Saque realizado com sucesso. Saldo anterior: " + initialSaldo
                + " Saldo atual: " + clienteService.getSaldo(id));
    }

    // todo: fazer transferencia de cliente para outro cliente
    @PutMapping("/conta/{id}/transferir/{idDestino}/{valor}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> fazerTransferencia(@PathVariable Long id, @PathVariable Long idDestino,
            @PathVariable Double valor) {
        Double accountSender = clienteService.getSaldo(id);
        Double accountReceiver = clienteService.getSaldo(idDestino);

        if (id != idDestino) {
            clienteService.transferirDinheiro(id, idDestino, valor);
            return ResponseEntity.ok().body("Transferencia realizada com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("Não é possivel transferir para a mesma conta");
        }
    }

    // todo: mostrar extrato do cliente
    @GetMapping("/{contaId}/extrato")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Transacao> mostrarExtrato(@PathVariable("contaId") Long contaId) {
        return transacaoService.listarTransacoes(contaId);
    }
}
