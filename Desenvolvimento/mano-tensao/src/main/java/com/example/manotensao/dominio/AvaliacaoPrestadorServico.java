package com.example.manotensao.dominio;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity

public class AvaliacaoPrestadorServico implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAvaliacaoPrestador;

    @Min(0)
    @NotBlank
    @ManyToOne
    private Proposta fkProposta;

    @Size(min = 0,max = 5)
    @NotBlank
    private Double notaPrestadorServico;

    @Size(max = 255)
    @NotBlank
    private String comentarioPrestadorServico;

    public Integer getIdAvaliacaoPrestador() {
        return idAvaliacaoPrestador;
    }

    public void setIdAvaliacaoPrestador(Integer idAvaliacaoPrestador) {
        this.idAvaliacaoPrestador = idAvaliacaoPrestador;
    }

    public Proposta getFkProposta() {
        return fkProposta;
    }

    public void setFkProposta(Proposta fkProposta) {
        this.fkProposta = fkProposta;
    }

    public Double getNotaPrestadorServico() {
        return notaPrestadorServico;
    }

    public void setNotaPrestadorServico(Double notaPrestadorServico) {
        this.notaPrestadorServico = notaPrestadorServico;
    }

    public String getComentarioPrestadorServico() {
        return comentarioPrestadorServico;
    }

    public void setComentarioPrestadorServico(String comentarioPrestadorServico) {
        this.comentarioPrestadorServico = comentarioPrestadorServico;
    }
}
