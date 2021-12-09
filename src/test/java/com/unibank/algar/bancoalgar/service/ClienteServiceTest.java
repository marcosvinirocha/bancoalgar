package com.unibank.algar.bancoalgar.service;

import java.util.Optional;

import com.unibank.algar.bancoalgar.AplicationConfigTest;
import com.unibank.algar.bancoalgar.entity.Cliente;
import com.unibank.algar.bancoalgar.repository.ClienteRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

@DisplayName("ClienteServiceTest")
public class ClienteServiceTest extends AplicationConfigTest {
    @MockBean
    private ClienteRepository clienteRepository;

    @MockBean
    private TransacaoService transacaoService;

    @Autowired
    private ClienteService clienteService;

    @Test
    @DisplayName("Criar Conta")
    public void deveCriarUmaContaClienteCorreta() {
        Cliente salvarCliente = new Cliente();

        Cliente clienteMock = Mockito.mock(Cliente.class);

        Mockito.when(clienteRepository.save(ArgumentMatchers.eq(salvarCliente))).thenReturn(clienteMock);

        clienteService.criarConta(salvarCliente);

        Mockito.verify(clienteRepository, Mockito.times(1)).save(ArgumentMatchers.any(Cliente.class));

    }

    @Test
    @DisplayName("Cliente Info")
    public void deveMostrarClientePeloId() {
        Long idCliente = 1L;
        Cliente clienteMock = Mockito.mock(Cliente.class);

        Optional<Cliente> clienteOptional = Optional.of(clienteMock);

        Mockito.when(clienteRepository.findById(ArgumentMatchers.eq(idCliente))).thenReturn(clienteOptional);

        clienteService.clienteInfo(idCliente);

        Mockito.verify(clienteRepository, Mockito.times(1)).findById(ArgumentMatchers.any());

    }
}
