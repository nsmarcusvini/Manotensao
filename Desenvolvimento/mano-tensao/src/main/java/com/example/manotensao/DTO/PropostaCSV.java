package com.example.manotensao.DTO;

public class PropostaCSV {
    private String nomeCliente;
    private Integer qtdDias;
    private Double qtdHoras;
    private Double valorTotal;
    private String bairro;
    private String rua;

    public PropostaCSV(String nomeCliente, Integer qtdDias, Double qtdHoras, Double valorTotal, String bairro, String rua) {
        this.nomeCliente = nomeCliente;
        this.qtdDias = qtdDias;
        this.qtdHoras = qtdHoras;
        this.valorTotal = valorTotal;
        this.bairro = bairro;
        this.rua = rua;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public Integer getQtdDias() {
        return qtdDias;
    }

    public Double getQtdHoras() {
        return qtdHoras;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }
}
