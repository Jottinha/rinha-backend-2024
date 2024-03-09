package com.joaovitor.services;

import com.joaovitor.domain.extrato.ExtratoRetorno;
import com.joaovitor.domain.extrato.SaldoExtrato;
import com.joaovitor.domain.transacoes.Transacao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtratoService {

    private ClientesService serviceCliente;
    private TransacoesService transacoesService;

    public ExtratoService(ClientesService serviceCliente, TransacoesService transacoesService) {
        this.serviceCliente = serviceCliente;
        this.transacoesService = transacoesService;
    }

    public ExtratoRetorno getExtrato(long idCliente){
        List<Transacao> ultimasTransacoes = transacoesService.getTransacoes(idCliente);
        ExtratoRetorno extrato = new ExtratoRetorno(getSaldoUsadoNoExtrato(idCliente), ultimasTransacoes);
        return extrato;
    }

    public SaldoExtrato getSaldoUsadoNoExtrato(long idCliente){
        int valorSaldo = transacoesService.buscandoSaldoPeloHistoricoTransacoes(idCliente);
        int limiteCliente = serviceCliente.buscaLimite(idCliente);
        SaldoExtrato saldoEstrato = new SaldoExtrato(valorSaldo, limiteCliente);

        return saldoEstrato;
    }
}
