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
}
