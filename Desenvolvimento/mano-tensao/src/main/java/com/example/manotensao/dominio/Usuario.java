package com.example.manotensao.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Size(max = 45,min = 3)
    private String nomeUsuario;

    @Size(max = 45,min = 3)
    private String senhaUsuario;

    @PastOrPresent
    private LocalDate dtNacimento;

    @Size(max = 45,min = 3)
    private String bairro;

    @Size(max = 45,min = 3)
    private String rua;
    @Min(0)
    private Integer numero;

    @Size(max = 45,min = 3)
    private String complemento;

}
