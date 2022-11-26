package com.example.manotensao.dto;

import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Usuario{

    @Size(max = 45,min = 3)
    @NotBlank
    private String nome;

    @Email
    @Size(max = 45)
    @NotBlank
    private String email;

    @Size(max = 45,min = 3)
    @NotBlank
    private String senha;
    private String telefone;

    private String cpf;

    private LocalDate dtNascimento;

    private String cep;

    private String bairro;

    private String rua;

    private Integer numero;

    private String complemento;

    private Integer autenticado;

    private String urlFoto;

    public Boolean autenticar(String email, String senha){
        return this.getEmail().equals(email) && this.pegarSenha().equals(senha);
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

    public String pegarSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Integer autenticado) {
        this.autenticado = autenticado;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
