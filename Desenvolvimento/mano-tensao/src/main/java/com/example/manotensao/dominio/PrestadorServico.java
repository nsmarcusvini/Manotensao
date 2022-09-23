package com.example.manotensao.dominio;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Table(name = "PrestadorServico")
public class PrestadorServico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrestadorServico")
    private Integer idPrestadorServico;

    @Min(0)
    @Column(name = "fkServico")
    private Integer fkServico;

    @Min(0)
    @Column(name = "fkPlano")
    private Integer fkPlano;

    @Size(max = 45,min = 3)
    @Column(name = "nomePrestador")
    private String nomePrestador;

    @Size(max = 45,min = 3)
    @Column(name = "senhaPrestador")
    private String senhaPrestador;

    @PastOrPresent
    @Column(name = "dtNascimento")
    private LocalDate dtNascimento;

    @Size(max = 45,min = 3)
    @Column(name = "bairro")
    private String bairro;

    @Size(max = 45,min = 3)
    @Column(name = "rua")
    private String rua;
    @Min(0)
    @Column(name = "numero")
    private Integer numero;

    @Size(max = 45,min = 3)
    @Column(name = "complemento")
    private String complemento;

    @Min(0)
    private Double valorHoraTrabalhada;

    @Min(0)
    private Double qtdHoraTrabalhada;

    public Integer getIdPrestadorServico() {
        return idPrestadorServico;
    }

    public void setIdPrestadorServico(Integer idPrestadorServico) {
        this.idPrestadorServico = idPrestadorServico;
    }

    public Integer getFkServico() {
        return fkServico;
    }

    public void setFkServico(Integer fkServico) {
        this.fkServico = fkServico;
    }

    public Integer getFkPlano() {
        return fkPlano;
    }

    public void setFkPlano(Integer fkPlano) {
        this.fkPlano = fkPlano;
    }

    public String getNomePrestador() {
        return nomePrestador;
    }

    public void setNomePrestador(String nomePrestador) {
        this.nomePrestador = nomePrestador;
    }

    public String getSenhaPrestador() {
        return senhaPrestador;
    }

    public void setSenhaPrestador(String senhaPrestador) {
        this.senhaPrestador = senhaPrestador;
    }

    public LocalDate getDtNacimento() {
        return dtNascimento;
    }

    public void setDtNacimento(LocalDate dtNacimento) {
        this.dtNascimento = dtNacimento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Double getValorHoraTrabalhada() {
        return valorHoraTrabalhada;
    }

    public void setValorHoraTrabalhada(Double valorHoraTrabalhada) {
        this.valorHoraTrabalhada = valorHoraTrabalhada;
    }

    public Double getQtdHoraTrabalhada() {
        return qtdHoraTrabalhada;
    }

    public void setQtdHoraTrabalhada(Double qtdHoraTrabalhada) {
        this.qtdHoraTrabalhada = qtdHoraTrabalhada;
    }
}
