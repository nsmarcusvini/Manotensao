package com.example.manotensao.dominio;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAvaliacao;

    @Min(0)
    private Integer fkUsuario;

    @Min(0)
    private Integer fkPrestadorServico;

    @Min(0)
    private Integer fkProposta;

    @Size(min = 0,max = 5)
    private Double nota;

    @Max(255)
    private String comentario;

    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Integer getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public Integer getFkPrestadorServico() {
        return fkPrestadorServico;
    }

    public void setFkPrestadorServico(Integer fkPrestadorServico) {
        this.fkPrestadorServico = fkPrestadorServico;
    }

    public Integer getFkProposta() {
        return fkProposta;
    }

    public void setFkProposta(Integer fkProposta) {
        this.fkProposta = fkProposta;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
