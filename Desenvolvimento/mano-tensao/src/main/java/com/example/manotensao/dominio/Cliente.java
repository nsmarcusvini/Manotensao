package com.example.manotensao.dominio;

import com.example.manotensao.DTO.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Cliente extends Usuario implements Serializable{

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCLiente;

    public Integer getIdCLiente() {
        return idCLiente;
    }

    public void setIdCLiente(Integer idCLiente) {
        this.idCLiente = idCLiente;
    }
}


