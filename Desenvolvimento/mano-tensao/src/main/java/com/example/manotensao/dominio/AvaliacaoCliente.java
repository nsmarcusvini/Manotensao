package com.example.manotensao.dominio;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
public class AvaliacaoCliente implements Serializable{
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAvaliacaoCliente;



    @ManyToOne
    private Proposta fkProposta;



    private Double notaCliente;


    private String comentarioCliente;

    public Integer getIdAvaliacao() {
        return idAvaliacaoCliente;
    }

    public void setIdAvaliacao(Integer idAvaliacao) {
        this.idAvaliacaoCliente = idAvaliacao;
    }

    public Proposta getFkProposta() {
        return fkProposta;
    }

    public void setFkProposta(Proposta fkProposta) {
        this.fkProposta = fkProposta;
    }

    public Double getNota() {
        return notaCliente;
    }

    public void setNota(Double nota) {
        this.notaCliente = nota;
    }

    public String getComentario() {
        return comentarioCliente;
    }

    public void setComentario(String comentario) {
        this.comentarioCliente = comentario;
    }
}
