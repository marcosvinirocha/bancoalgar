package com.unibank.algar.bancoalgar.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.unibank.algar.bancoalgar.AplicationConfigTest;
import com.unibank.algar.bancoalgar.entity.Transacao;
import com.unibank.algar.bancoalgar.service.ClienteService;
import com.unibank.algar.bancoalgar.service.TransacaoService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@DisplayName("ClienteControllerTest")
public class ClienteControllerTest extends AplicationConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @MockBean
    private TransacaoService transacaoService;

    @Test
    @DisplayName("Deve deve mostrar cliente")
    public void deveMostrarCliente() throws Exception {
        String uri = "/cliente/conta/1";

        mockMvc.perform(get(uri))
                .andExpect(status().isOk());

        verify(clienteService, times(1)).clienteInfo(anyLong());
    }

    @Test
    @DisplayName("Deve deve mostrar extrato do cliente")
    public void deveMostrarExtrato() throws Exception {
        String uri = "/cliente/1/extrato";

        mockMvc.perform(get(uri))
                .andExpect(status().isOk());

        verify(transacaoService, times(1)).listarTransacoes(anyLong());
    }

    @Test
    @DisplayName("Deve fazer um deposito na conta do cliente")
    public void deveFazerDeposito() throws Exception {
        String uri = "/cliente/conta/1/deposito/300";

        mockMvc.perform(put(uri)).andExpect(status().isOk());

        verify(clienteService, times(1)).depositar(anyLong(), anyDouble());
        verify(transacaoService, times(1)).salvarTransacao(any(Transacao.class));
    }

    @Test
    @DisplayName("Deve fazer um saque na conta do cliente")
    public void deveFazerSaque() throws Exception {
        String uri = "/cliente/conta/1/saque/300";

        mockMvc.perform(put(uri)).andExpect(status().isOk());

        verify(clienteService, times(1)).sacar(anyLong(), anyDouble());
        verify(transacaoService, times(1)).salvarTransacao(any(Transacao.class));
    }

    @Test
    @DisplayName("Deve fazer uma tranasferencia na conta do cliente")
    public void deveFazerTransferenciaDinheiro() throws Exception {
        String uri = "/cliente/conta/1/transferir/4/300";

        mockMvc.perform(put(uri)).andExpect(status().isOk());

        verify(clienteService, times(1)).transferirDinheiro(anyLong(), anyLong(), anyDouble());
    }
}
