package com.unibank.algar.bancoalgar.controller;

import java.util.List;

import com.unibank.algar.bancoalgar.controller.dto.ClienteDto;
import com.unibank.algar.bancoalgar.entity.Cliente;
import com.unibank.algar.bancoalgar.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Cliente> listaCliente() {
        return clienteRepository.findAll();
    }

    // Mostrar saldo do cliente
    @GetMapping("/saldo/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<ClienteDto> exibirSaldo(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(new ClienteDto(cliente.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // todo: fazer o deposito do cliente

    // todo: fazer o saque do cliente

    // todo: fazer transferencia de cliente para outro cliente

    // todo: mostrar extrato do cliente

}
