package com.example.manotensao.dto;

import com.example.manotensao.dominio.Cliente;
import com.example.manotensao.dominio.PrestadorServico;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class Chat {
    private Integer id;
    private String cliente;
    private String prestador;
    private LocalDateTime dataHora;
    private String mensagem;

    public Integer getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getPrestador() {
        return prestador;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getMensagem() {
        return mensagem;
    }
}
