package br.univille.projfabsoftmp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

@Entity
public class Implementation extends Demand {

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataVencimento;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataInicioImplantacao;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataConclusao;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataAssinatura;

    public Implementation() {
        
    }

    public Implementation(Date dataVencimento, Date dataInicioImplantacao, Date dataConclusao) {
        this.dataVencimento = dataVencimento;
        this.dataInicioImplantacao = dataInicioImplantacao;
        setDataConclusao(dataConclusao); // já define a assinatura também
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataInicioImplantacao() {
        return dataInicioImplantacao;
    }

    public void setDataInicioImplantacao(Date dataInicioImplantacao) {
        this.dataInicioImplantacao = dataInicioImplantacao;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;

        // Calcula dataAssinatura = dataConclusao + 35 dias
        if (dataConclusao != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(dataConclusao);
            cal.add(Calendar.DAY_OF_MONTH, 35);
            this.dataAssinatura = cal.getTime();
        } else {
            this.dataAssinatura = null;
        }
    }

    public Date getDataAssinatura() {
        return dataAssinatura;
    }

    // Método privado para evitar sobrescrita direta da dataAssinatura
    private void setDataAssinatura(Date dataAssinatura) {
        this.dataAssinatura = dataAssinatura;
    }
}
