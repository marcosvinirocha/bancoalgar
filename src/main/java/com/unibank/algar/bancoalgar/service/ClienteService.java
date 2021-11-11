package com.unibank.algar.bancoalgar.service;

import java.util.List;

import com.unibank.algar.bancoalgar.entity.Cliente;
import com.unibank.algar.bancoalgar.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarCliente() {
        return clienteRepository.findAll();
    }
}
