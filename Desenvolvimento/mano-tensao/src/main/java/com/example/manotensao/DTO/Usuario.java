package com.example.manotensao.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.BooleanFlag;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.*;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    //@Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})\n")
    @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$")
    private String telefone;

    @CPF
    private String cpf;

    @PastOrPresent
    private LocalDate dtNascimento;

    @Size(max = 45,min = 3)
    private String bairro;

    @Size(max = 45,min = 3)
    private String rua;
    @Min(0)
    private Integer numero;

    @Size(max = 45,min = 3)
    private String complemento;


    private Boolean autenticado;

    public Boolean autenticar(String email, String senha){
        return this.getEmail().equals(email) && this.pegarSenha().equals(senha);
    }

    public Integer pegarId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean pegarAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }
}
