package com.example.manotensao.dto;

public class BoletoTxt {
    private String nome;
    private String cep;
    private String dtnasc;
    private Integer numero;
    private String complemento;
    private String telefone;
    private String tipoPlano;
    private Double valorPlano;

    public BoletoTxt(String nome, String cep, String dtnasc,
                     Integer numero, String complemento, String telefone,
                     String tipoPlano, Double valorPlano) {
        this.nome = nome;
        this.cep = cep;
        this.dtnasc = dtnasc;
        this.numero = numero;
        this.complemento = complemento;
        this.telefone = telefone;
        this.tipoPlano = tipoPlano;
        this.valorPlano = valorPlano;
    }

    public String getNome() {
        return nome;
    }

    public String getCep() {
        return cep;
    }

    public String getDtnasc() {
        return dtnasc;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getTipoPlano() {
        return tipoPlano;
    }

    public Double getValorPlano() {
        return valorPlano;
    }
}
