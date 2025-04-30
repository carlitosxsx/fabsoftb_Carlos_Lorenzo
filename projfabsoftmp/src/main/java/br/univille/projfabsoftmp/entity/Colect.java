package br.univille.projfabsoftmp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Colect extends Demand {

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataPagamento;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataPrimeiroContato;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataColetaConcluida;

    private int tmc; // Tempo Médio de Coleta (em dias)

    public Colect() {
    }
    
    public Colect(Date dataPagamento, Date dataPrimeiroContato, Date dataColetaConcluida, int tmc) {
        this.dataPagamento = dataPagamento;
        this.dataPrimeiroContato = dataPrimeiroContato;
        this.dataColetaConcluida = dataColetaConcluida;
        this.tmc = tmc;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataPrimeiroContato() {
        return dataPrimeiroContato;
    }

    public void setDataPrimeiroContato(Date dataPrimeiroContato) {
        this.dataPrimeiroContato = dataPrimeiroContato;
    }

    public Date getDataColetaConcluida() {
        return dataColetaConcluida;
    }

    public void setDataColetaConcluida(Date dataColetaConcluida) {
        this.dataColetaConcluida = dataColetaConcluida;
    }

    public int getTmc() {
        return tmc;
    }

    public void setTmc(int tmc) {
        this.tmc = tmc;
    }
}
