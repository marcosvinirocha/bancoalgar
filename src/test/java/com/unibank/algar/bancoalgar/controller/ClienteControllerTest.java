package com.unibank.algar.bancoalgar.controller;

import com.unibank.algar.bancoalgar.AplicationConfigTest;
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

    private static final String PATH = "/cliente";

    // @Test
    // @DisplayName("Deve cadastrar um cliente")
}
