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

    public List<Transacao> getTransacoes(long idCliente){
        List<Transacao> ultimasTransacoes = repository.findTransacoesByIdCliente(idCliente);
        return ultimasTransacoes;
    }

    public TransacaoRetorno insertTransacoes(TransacaoDTO novaTransacao, int idCliente){

        if (!verificaDescricao(novaTransacao.descricao()) || !verificatipo(novaTransacao.tipo())){
            return null;
        }
        if (!serviceCliente.clienteExiste(idCliente)){
            TransacaoRetorno retorno = new TransacaoRetorno();
            retorno.setClienteValido(false);
            return retorno;
        }

        TransacaoRetorno retorno = atualizaSaldoOuLimite(novaTransacao, idCliente);
        if (retorno != null){
            retorno.setClienteValido(true);
            repository.save(new Transacao(novaTransacao, idCliente));
        }

        return retorno;
    }

    public TransacaoRetorno atualizaSaldoOuLimite(TransacaoDTO novaTransacao, int idCliente){
        String debito = "d";
        if (novaTransacao.tipo().equals(debito)){
            int novoSaldo = buscandoSaldoPeloHistoricoTransacoes((long) idCliente) + novaTransacao.valor();

            if (novoSaldo < 0){
                return null;
            }
            TransacaoRetorno retornoSaldoAtualizado = new TransacaoRetorno(serviceCliente.buscaLimite(idCliente), novoSaldo);
            return retornoSaldoAtualizado;
        }

        int novoLimite = serviceCliente.buscaLimite(idCliente) + novaTransacao.valor();
        if (novoLimite < 0){
            return null;
        }
        serviceCliente.atualizaLimite(idCliente, novoLimite);
        return new TransacaoRetorno(novoLimite, buscandoSaldoPeloHistoricoTransacoes((long) idCliente));
    }

    public int buscandoSaldoPeloHistoricoTransacoes(long idCliente){
        List<Transacao> transacoesDoCliente = repository.findTransacoesByIdCliente(idCliente);

        int totalTransacoes = 0;
        for (Transacao historicoTransacoes : transacoesDoCliente){
            if (historicoTransacoes.getTipo().equals("d")){
                totalTransacoes += historicoTransacoes.getValor();
            }
        }

        return totalTransacoes;
    }

    public boolean verificaDescricao(String descricao){
        return (descricao.length() < 10) ? true : false;
    }
    public boolean verificatipo(String tipo){
        return (tipo.equals("d") || tipo.equals("c")) ? true : false;
    }

}
