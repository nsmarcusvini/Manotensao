package com.example.manotensao.dominio;

import com.example.manotensao.DTO.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Cliente extends Usuario implements Serializable{

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCLiente;

    public Integer pegarId() {
        return idCLiente;
    }

    public void setId(Integer idCLiente) {
        this.idCLiente = idCLiente;
    }
}


