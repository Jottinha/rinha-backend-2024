package com.joaovitor.domain.transacoes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int valor;
    private String tipo;
    private String descricao;
    private Date realizada_em;
    private int idCliente;

    public Transacao(){
    }

    public Transacao(TransacaoDTO transacaoDto, int idCliente){

        LocalDateTime now = LocalDateTime.now();

        this.valor = transacaoDto.valor();
        this.tipo = transacaoDto.tipo();
        this.descricao = transacaoDto.descricao();
        this.realizada_em = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        this.idCliente = idCliente;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getRealizada_em() {
        return realizada_em;
    }

    public void setRealizada_em(Date realizada_em) {
        this.realizada_em = realizada_em;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
