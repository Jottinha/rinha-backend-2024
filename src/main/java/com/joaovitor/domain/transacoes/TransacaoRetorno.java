package com.joaovitor.domain.transacoes;

public class TransacaoRetorno {
    int limite;
    int saldo;

    public TransacaoRetorno(int limite, int saldo) {
        this.limite = limite;
        this.saldo = saldo;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
