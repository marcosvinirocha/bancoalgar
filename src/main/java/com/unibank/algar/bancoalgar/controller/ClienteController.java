package com.unibank.algar.bancoalgar.controller;

import com.unibank.algar.bancoalgar.entity.Cliente;
import com.unibank.algar.bancoalgar.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Todo: criar conta
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente) {
        return clienteService.criarConta(cliente);
    }

    // Todo:Mostrar saldo do cliente
    @GetMapping("/{id}/saldo")
    @ResponseStatus(value = HttpStatus.OK)
    public Double mostrarSaldo(@PathVariable Long id) {
        return clienteService.getSaldo(id);
    }

    // todo: fazer o deposito do cliente

    // todo: fazer o saque do cliente

    // todo: fazer transferencia de cliente para outro cliente

    // todo: mostrar extrato do cliente

}
