package com.unibank.algar.bancoalgar.service;

import com.unibank.algar.bancoalgar.entity.Transacao;
import com.unibank.algar.bancoalgar.repository.TransacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public void salvarTransacao(Transacao transacao) {
        transacaoRepository.save(transacao);
    }

}
