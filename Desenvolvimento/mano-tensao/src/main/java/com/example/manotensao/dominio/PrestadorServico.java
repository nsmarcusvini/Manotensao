package com.example.manotensao.dominio;

import com.example.manotensao.DTO.Usuario;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class PrestadorServico extends Usuario implements Serializable {

    @Min(0)
    @JoinColumn(name = "idServico")
    private Integer fkServico;

    @Min(0)
    @JoinColumn(name = "idPlano")
    private Integer fkPlano;

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

}
