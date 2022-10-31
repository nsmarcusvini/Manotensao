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

    @Min(0)
    @ManyToOne
    private Servico fkServico;

    @Min(0)
    @ManyToOne
    private Plano fkPlano;

    public Integer pegarId() {
        return idPrestador;
    }

    public void setId(Integer idPrestador) {
        this.idPrestador = idPrestador;
    }

    public Servico getFkServico() {
        return fkServico;
    }

    public void setFkServico(Servico fkServico) {
        this.fkServico = fkServico;
    }

    public Plano getFkPlano() {
        return fkPlano;
    }

    public void setFkPlano(Plano fkPlano) {
        this.fkPlano = fkPlano;
    }

}
