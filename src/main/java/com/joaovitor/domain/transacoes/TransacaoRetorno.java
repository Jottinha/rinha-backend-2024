package com.joaovitor.domain.transacoes;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TransacaoRetorno {
    int limite;
    int saldo;
    boolean clienteValido;

    public TransacaoRetorno(){

    }
    public TransacaoRetorno(int limite, int saldo) {
        this.limite = limite;
        this.saldo = saldo;
    }
    @JsonIgnore
    public boolean isClienteValido() {
        return clienteValido;
    }

    public void setClienteValido(boolean clienteValido) {
        this.clienteValido = clienteValido;
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
