package com.unibank.algar.bancoalgar.controller;

import java.util.List;

import com.unibank.algar.bancoalgar.entity.Cliente;
import com.unibank.algar.bancoalgar.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Cliente> listaCliente() {
        return clienteService.listarCliente();
    }

}
