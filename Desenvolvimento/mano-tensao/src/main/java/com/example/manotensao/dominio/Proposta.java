package com.example.manotensao.dominio;


import com.example.manotensao.dto.PropostaCSV;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;

@Entity
public class Proposta implements Serializable{
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProposta;

    @Min(0)
    @NotBlank
    @ManyToOne
    private Cliente fkCliente;

    @Min(0)
    @NotBlank
    @ManyToOne
    private PrestadorServico fkPrestadorServico;

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

    @PastOrPresent
    private LocalDate dataProposta;

    public Integer getIdProposta() {
        return idProposta;
    }

    public void setIdProposta(Integer idUsuario) {
        this.idProposta = idUsuario;
    }

    public Cliente getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Cliente fkCliente) {
        this.fkCliente = fkCliente;
    }

    public PrestadorServico getFkPrestadorServico() {
        return fkPrestadorServico;
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

    public void setFkPrestadorServico(PrestadorServico fkPrestadorServico) {
        this.fkPrestadorServico = fkPrestadorServico;
    }


    public LocalDate getDataProposta() {
        return dataProposta;
    }

    public void setDataProposta(LocalDate dataProposta) {
        this.dataProposta = dataProposta;
    }
}
