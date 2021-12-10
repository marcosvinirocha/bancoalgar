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

    @Test
    @DisplayName("Mostrar Saldo")
    public void deveMostrarSaldoClientePeloId() {
        Long idCliente = 1L;
        Cliente clienteMock = Mockito.mock(Cliente.class);

        Double saldo = clienteMock.getSaldo();

        Mockito.when(clienteRepository.findSaldoById(ArgumentMatchers.eq(idCliente))).thenReturn(saldo);

        clienteService.getSaldo(idCliente);

        Mockito.verify(clienteRepository, Mockito.times(1)).findSaldoById(ArgumentMatchers.any());

    }

    @Test
    @DisplayName("Fazer deposito")
    public void deveDepositarDinheiro() {
        Long idCliente = 1L;
        Double valor = (double) 100;

        clienteService.depositar(idCliente, valor);

        Mockito.verify(clienteRepository, Mockito.times(1)).fazerDeposito(ArgumentMatchers.any(),
                ArgumentMatchers.any());

    }

    @Test
    @DisplayName("Fazer Saque")
    public void deveSacarDinheiro() {
        Long idCliente = 1L;
        Double valor = (double) 100;

        clienteService.sacar(idCliente, valor);

        Mockito.verify(clienteRepository, Mockito.times(1)).fazerSaque(ArgumentMatchers.any(),
                ArgumentMatchers.any());

    }

    @Test
    @DisplayName("Fazer Transferencia")
    public void deveFazerTransferenciaDinheiro() {
        Long idCliente = 1L;
        Long idClienteDestino = 2L;
        Double valor = (double) 100;

        clienteService.transferirDinheiro(idCliente, idClienteDestino, valor);

        Mockito.verify(clienteRepository, Mockito.times(1)).fazerSaque(ArgumentMatchers.any(),
                ArgumentMatchers.any());

        Mockito.verify(clienteRepository, Mockito.times(1)).fazerDeposito(ArgumentMatchers.any(),
                ArgumentMatchers.any());

    }
}
