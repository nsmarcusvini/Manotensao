package com.example.manotensao.dto;

public class FiltroPorAvaliacao{
    private String nome;
    private String email;
    private String urlFoto;
    private String telefone;
    private Double media;
    private String cep;

    public FiltroPorAvaliacao(String nome, String email, String urlFoto, String telefone, Double media, String cep) {
        this.nome = nome;
        this.email = email;
        this.urlFoto = urlFoto;
        this.telefone = telefone;
        this.media = media;
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public String getTelefone() {
        return telefone;
    }

    public Double getMedia() {
        return media;
    }

    public String getCep() {
        return cep;
    }
}
