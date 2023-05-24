package com.example.manotensao.dto;

public class FiltroPorAvaliacao{

    private Integer id;
    private String nome;
    private String email;
    private String urlFoto;
    private String telefone;
    private Double media;
    private String cep;

    private String bairro;

    private String rua;

    private Integer numero;


    public FiltroPorAvaliacao(Integer id, String nome, String email, String urlFoto, String telefone, Double media, String cep, String bairro, String rua, Integer numero) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.urlFoto = urlFoto;
        this.telefone = telefone;
        this.media = media;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }

    public Integer getId(){return id;}

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

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public Integer getNumero() {
        return numero;
    }
}
