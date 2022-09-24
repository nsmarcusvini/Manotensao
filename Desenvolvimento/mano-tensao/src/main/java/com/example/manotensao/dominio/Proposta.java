package com.example.manotensao.dominio;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "Proposta")
public class Proposta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Min(0)
    private Integer fkUsuario;

    @Min(0)
    private Integer fkPrestadorServico;

    @Min(0)
    private Double qtdHoras;

    @Min(0)
    private Double valorTotal;

    @Size(min = 0, max = 7)
    private Integer qtdDias;

    @Size(min = 0, max = 1)
    private Integer propostaAceita;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public Integer getFkPrestadorServico() {
        return fkPrestadorServico;
    }

    public void setFkPrestadorServico(Integer fkPrestadorServico) {
        this.fkPrestadorServico = fkPrestadorServico;
    }

    public Double getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(Double qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getQtdDias() {
        return qtdDias;
    }

    public void setQtdDias(Integer qtdDias) {
        this.qtdDias = qtdDias;
    }

    public Integer getPropostaAceita() {
        return propostaAceita;
    }

    public void setPropostaAceita(Integer propostaAceita) {
        this.propostaAceita = propostaAceita;
    }
}
