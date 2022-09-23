package com.example.manotensao.dominio;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "AvaliacaoUsuario")
public class AvaliacaoUsuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAvaliacao")
    private Integer idAvaliacao;
    @Min(0)
    @Column(name = "fkProposta")
    private Integer fkProposta;

    @Size(min = 0,max = 5)
    @Column(name = "notaUsuario")
    private Double notaUsuario;

    @Max(255)
    @Column(name = "comentarioUsuario")
    private String comentarioUsuario;

    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Integer getFkProposta() {
        return fkProposta;
    }

    public void setFkProposta(Integer fkProposta) {
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
