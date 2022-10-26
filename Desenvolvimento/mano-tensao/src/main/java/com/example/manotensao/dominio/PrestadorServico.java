package com.example.manotensao.dominio;

import com.example.manotensao.DTO.Usuario;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
public class PrestadorServico extends Usuario implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPrestador;

    public Integer getIdPrestador() {
        return idPrestador;
    }

    public void setIdPrestador(Integer idPrestador) {
        this.idPrestador = idPrestador;
    }

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
