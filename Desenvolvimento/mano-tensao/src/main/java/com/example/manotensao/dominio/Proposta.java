package com.example.manotensao.dominio;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Proposta implements Serializable {
    @Id
    @NotBlank
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProposta;

    @Min(0)
    @NotBlank
    private Integer fkUsuario;

    @Min(0)
    @NotBlank
    private Integer fkPrestadorServico;

    @Min(0)
    @NotBlank
    private Double qtdHoras;

    @Min(0)
    @NotBlank
    private Double valorTotal;

    @Size(min = 0, max = 7)
    @NotBlank
    private Integer qtdDias;

    @Size(min = 0, max = 1)
    @NotBlank
    private Integer propostaAceita;

    public Integer getIdProposta() {
        return idProposta;
    }

    public void setIdProposta(Integer idUsuario) {
        this.idProposta = idUsuario;
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
