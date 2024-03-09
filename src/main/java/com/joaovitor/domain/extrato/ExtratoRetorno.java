package com.joaovitor.domain.extrato;

import com.joaovitor.domain.transacoes.Transacao;

import java.util.List;

public class ExtratoRetorno {
    private SaldoExtrato saldo;
    private List<Transacao> ultimasTransacoes;

    public ExtratoRetorno(SaldoExtrato saldo, List<Transacao> ultimasTransacoes) {
        this.saldo = saldo;
        this.ultimasTransacoes = ultimasTransacoes;
    }

    public SaldoExtrato getSaldo() {
        return saldo;
    }

    public void setSaldo(SaldoExtrato saldo) {
        this.saldo = saldo;
    }

    public List<Transacao> getUltimasTransacoes() {
        return ultimasTransacoes;
    }

    public void setUltimasTransacoes(List<Transacao> ultimasTransacoes) {
        this.ultimasTransacoes = ultimasTransacoes;
    }
}
