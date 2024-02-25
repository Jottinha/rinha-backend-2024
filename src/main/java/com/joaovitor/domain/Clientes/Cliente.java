package com.joaovitor.domain.Clientes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente {
    @Id
    private Long id;
    private long limite;
    private long saldoInicial;

    public Cliente(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getLimite() {
        return limite;
    }

    public void setLimite(long limite) {
        this.limite = limite;
    }

    public long getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(long saldoInicial) {
        this.saldoInicial = saldoInicial;
    }
}
