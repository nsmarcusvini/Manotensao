package com.example.manotensao.DTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

public class CartaApresentacao {
    @Max(45)
    private String nome;

    @Max(45)
    private String email;

    @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$")
    private String telefone;

    @Max(255)
    private String apresentacao;

    public CartaApresentacao(String nome, String email, String telefone, String apresentacao) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.apresentacao = apresentacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getApresentacao() {
        return apresentacao;
    }

    public void setApresentacao(String apresentacao) {
        this.apresentacao = apresentacao;
    }
}
