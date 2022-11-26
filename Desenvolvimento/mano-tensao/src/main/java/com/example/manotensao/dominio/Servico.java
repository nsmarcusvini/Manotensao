package com.example.manotensao.dominio;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Servico implements Serializable{


    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoServico;

    @Size(max = 45,min = 3)
    @NotBlank
    private String tipoServico;

    public Integer getIdTipoServico() {
        return idTipoServico;
    }

    public void setIdTipoServico(Integer idTipoServico) {
        this.idTipoServico = idTipoServico;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }
}
