package com.example.manotensao.dominio;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
public class AvaliacaoUsuario implements Serializable {
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
    private Double notaUsuario;

    @Size(max = 255)
    @NotBlank
    private String comentarioUsuario;

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
        return notaUsuario;
    }

    public void setNota(Double nota) {
        this.notaUsuario = nota;
    }

    public String getComentario() {
        return comentarioUsuario;
    }

    public void setComentario(String comentario) {
        this.comentarioUsuario = comentario;
    }
}
