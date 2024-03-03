package com.joaovitor.services;

import com.joaovitor.domain.transacoes.Transacao;
import com.joaovitor.domain.transacoes.TransacaoDTO;
import com.joaovitor.domain.transacoes.TransacaoRetorno;
import com.joaovitor.repository.Transacao.TransacaoRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacoesService {
    @Inject
    private TransacaoRepository repository;
    private ClientesService serviceCliente;
    public TransacoesService(TransacaoRepository repository, ClientesService serviceCliente) {
        this.repository = repository;
        this.serviceCliente = serviceCliente;
    }

    public TransacaoRetorno insertTransacoes(TransacaoDTO novaTransacao, int idCliente){

        int novoSaldo = buscandoSaldoPeloHistoricoTransacoes((long) idCliente) + novaTransacao.valor();
        TransacaoRetorno retorno = new TransacaoRetorno(serviceCliente.buscaLimite(idCliente), novoSaldo);

        repository.save(new Transacao(novaTransacao, idCliente));
        return retorno;
    }

    public int buscandoSaldoPeloHistoricoTransacoes(long idCliente){
        List<Transacao> transacoesDoCliente = repository.findHistoryTotalByIdCliente(idCliente);

        int totalTransacoes = 0;
        for (Transacao historicoTransacoes : transacoesDoCliente){
            totalTransacoes += historicoTransacoes.getValor();
        }

        return totalTransacoes;
    }
}
