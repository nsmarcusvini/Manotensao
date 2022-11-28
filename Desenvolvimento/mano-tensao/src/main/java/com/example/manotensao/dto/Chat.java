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
    private String remetente;
    private LocalDateTime dataHora;
    private String mensagem;

    public Chat(Integer id, String remetente, LocalDateTime dataHora, String mensagem) {
        this.id = id;
        this.remetente = remetente;
        this.dataHora = dataHora;
        this.mensagem = mensagem;
    }

    public Integer getId() {
        return id;
    }

    public String getRemetente() {
        return remetente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getMensagem() {
        return mensagem;
    }
}
