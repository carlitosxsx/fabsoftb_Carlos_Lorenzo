package br.univille.projfabsoftmp.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

@Entity
public class Production extends Demand {

    @ManyToOne
    private ProductionType tipo;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataVencimentoGeral;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataVencimentoCriacao;

    @ManyToOne
    @JoinColumn(name = "prazo_id")
    private DeadlineStatus prazo;

    @PrePersist
    @PreUpdate
    private void calcularAutomacoes() {
        if (dataVencimentoGeral != null && tipo != null && tipo.getName().equalsIgnoreCase("Normal")) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(dataVencimentoGeral);
            cal.add(Calendar.DAY_OF_MONTH, -2);
            this.dataVencimentoCriacao = cal.getTime();
        } else {
            this.dataVencimentoCriacao = dataVencimentoGeral;
        }

        // Cálculo de prazo apenas se ainda não estiver definido
        if (prazo == null && dataVencimentoCriacao != null) {
            Date hoje = new Date();
            String nomePrazo;
            if (dataVencimentoCriacao.equals(hoje)) {
                nomePrazo = "Vence hoje";
            } else if (dataVencimentoCriacao.after(hoje)) {
                nomePrazo = "Dentro do prazo";
            } else {
                nomePrazo = "Em atraso";
            }

            this.prazo = new DeadlineStatus(nomePrazo); // ideal: buscar via repository no serviço
        }
    }

    public ProductionType getTipo() {
        return tipo;
    }

    public void setTipo(ProductionType tipo) {
        this.tipo = tipo;
    }

    public Date getDataVencimentoGeral() {
        return dataVencimentoGeral;
    }

    public void setDataVencimentoGeral(Date dataVencimentoGeral) {
        this.dataVencimentoGeral = dataVencimentoGeral;
    }

    public Date getDataVencimentoCriacao() {
        return dataVencimentoCriacao;
    }

    public void setDataVencimentoCriacao(Date dataVencimentoCriacao){
        this.dataVencimentoCriacao = dataVencimentoCriacao;
    }

    public DeadlineStatus getPrazo() {
        return prazo;
    }

    public void setPrazo(DeadlineStatus prazo) {
        this.prazo = prazo;
    }
}
