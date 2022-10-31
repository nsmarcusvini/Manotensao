package com.example.manotensao.dominio;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
public class AvaliacaoCliente implements Serializable {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAvaliacaoCliente;

    @Min(0)
    @NotBlank
    @ManyToOne
    private Proposta fkProposta;


    @Size(min = 0,max = 5)
    @NotBlank
    private Double notaCliente;

    @Size(max = 255)
    @NotBlank
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
