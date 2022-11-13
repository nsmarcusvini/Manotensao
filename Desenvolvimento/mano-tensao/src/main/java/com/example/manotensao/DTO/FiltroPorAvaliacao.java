package com.example.manotensao.DTO;

public class FiltroPorAvaliacao{
    private String nome;
    private String email;
    private String urlFoto;
    private String telefone;
    private Double media;

    public FiltroPorAvaliacao(String nome, String email, String urlFoto, String telefone, Double media) {
        this.nome = nome;
        this.email = email;
        this.urlFoto = urlFoto;
        this.telefone = telefone;
        this.media = media;
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
}
