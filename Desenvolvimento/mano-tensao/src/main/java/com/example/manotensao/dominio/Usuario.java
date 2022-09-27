package com.example.manotensao.dominio;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    @Id
    @NotBlank
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Size(max = 45,min = 3)
    @NotBlank
    private String nomeUsuario;

    @Email
    @NotBlank
    @Size(max = 45)
    private String emailUsuario;

    @Size(max = 45,min = 3)
    @NotBlank
    private String senhaUsuario;

    @PastOrPresent
    private LocalDate dtNascimento;

    @Size(max = 45,min = 3)
    @NotBlank
    private String bairro;

    @Size(max = 45,min = 3)
    @NotBlank
    private String rua;
    @Min(0)
    @NotBlank
    private Integer numero;

    @Size(max = 45,min = 3)
    @NotBlank
    private String complemento;

    public Integer pegarIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String pegarSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public LocalDate getDtNacimento() {
        return dtNascimento;
    }

    public void setDtNacimento(LocalDate dtNacimento) {
        this.dtNascimento = dtNacimento;
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
}
