package com.example.manotensao.dominio;

import com.example.manotensao.DTO.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Cliente extends Usuario implements Serializable{
    @Id
    @NotBlank
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    public Integer pegarIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
}
