package com.example.manotensao.dominio;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity

@PrimaryKeyJoinColumn(name = "idAvaliacaoCliente")
public class AvaliacaoUsuario implements Serializable {
    @Id
    @NotBlank
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAvaliacaoCliente;
    @Min(0)
    @NotBlank
    private Integer fkProposta;

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
