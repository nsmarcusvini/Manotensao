package com.example.manotensao.dominio;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "AvaliacaoPrestadorServico")
public class AvaliacaoPrestadorServico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAvaliacao;
    @Min(0)
    private Integer fkProposta;

    @Size(min = 0,max = 5)
    private Double notaPrestadorServico;

    @Max(255)
    private String comentarioPrestadorServico;

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

    public Double getNotaUsuario() {
        return notaPrestadorServico;
    }

    public void setNotaUsuario(Double notaUsuario) {
        this.notaPrestadorServico = notaUsuario;
    }

    public String getComentarioUsuario() {
        return comentarioPrestadorServico;
    }

    public void setComentarioUsuario(String comentarioUsuario) {
        this.comentarioPrestadorServico = comentarioUsuario;
    }
}
