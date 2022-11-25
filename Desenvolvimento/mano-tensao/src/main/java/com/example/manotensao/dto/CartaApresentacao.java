package com.example.manotensao.dto;
public class CartaApresentacao {
    private String nome;
    private String email;
    private String telefone;
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
