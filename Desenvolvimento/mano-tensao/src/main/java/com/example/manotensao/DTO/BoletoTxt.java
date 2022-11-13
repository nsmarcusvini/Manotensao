package com.example.manotensao.DTO;

import com.example.manotensao.dominio.Plano;

import java.util.Date;

public class BoletoTxt {
    private String nomePrestador;
    private String plano;
    private Double valor;

    public BoletoTxt(String nomePrestador, String plano, Double valor) {
        this.nomePrestador = nomePrestador;
        this.plano = plano;
        this.valor = valor;
    }

    public String getNomePrestador() {
        return nomePrestador;
    }


    public String getPlano() {
        return plano;
    }



    public Double getValor() {
        return valor;
    }

}
