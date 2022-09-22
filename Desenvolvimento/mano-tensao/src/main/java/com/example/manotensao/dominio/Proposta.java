package com.example.manotensao.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Min(0)
    private Integer fkUsuario;

    @Min(0)
    private Integer fkPrestadorServico;

    @Min(0)
    private Double qtdHoras;

    @Min(0)
    private Double valorTotal;

    @Size(min = 0, max = 7)
    private Integer qtdDias;

    @Size(min = 0, max = 1)
    private Integer propostaAceita;

}
