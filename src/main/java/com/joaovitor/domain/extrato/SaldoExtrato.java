package com.joaovitor.domain.extrato;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class SaldoExtrato {
    private int total;
    private Date dataExtrato;
    private int limite;

    public SaldoExtrato(int total, int limite) {
        LocalDateTime now = LocalDateTime.now();

        this.total = total;
        this.dataExtrato = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        this.limite = limite;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getDataExtrato() {
        return dataExtrato;
    }

    public void setDataExtrato(Date dataExtrato) {
        this.dataExtrato = dataExtrato;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }
}
