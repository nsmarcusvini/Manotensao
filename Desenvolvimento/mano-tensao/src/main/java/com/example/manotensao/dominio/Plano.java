package com.example.manotensao.dominio;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlano;

    @Size(max = 45,min = 3)
    private String tipoPlano;

    public Integer getIdTipoServico() {
        return idPlano;
    }

    public void setIdTipoServico(Integer idTipoServico) {
        this.idPlano = idTipoServico;
    }

    public String getTipoServico() {
        return tipoPlano;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoPlano = tipoServico;
    }
}
