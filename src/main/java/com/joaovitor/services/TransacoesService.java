package com.joaovitor.services;

import com.joaovitor.domain.transacoes.Transacao;
import com.joaovitor.domain.transacoes.TransacaoDTO;
import com.joaovitor.repository.Transacao.TransacaoRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class TransacoesService {
    @Inject
    private TransacaoRepository repository;

    public TransacoesService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public Transacao insertTransacoes(TransacaoDTO novaTransacao, int idCliente){
        return repository.save(new Transacao(novaTransacao, idCliente));
    }
}
