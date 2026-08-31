package com.projetoindividual.pokemon;

import java.time.LocalDate;

public class Usuario {
    private Integer id;
    private String nome;
    private String nickname;
    private String email;
    private Integer idade;
    private LocalDate dataNascimento;
    private String sexo;
    private String tiposFavoritos;
    private String pokemonInicial;
    private String senha;

    public Usuario() {
    }

    public Usuario(Integer id, String nome, String nickname, String email, Integer idade, LocalDate dataNascimento, String sexo, String tiposFavoritos, String pokemonInicial, String senha) {
        this.id = id;
        this.nome = nome;
        this.nickname = nickname;
        this.email = email;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.tiposFavoritos = tiposFavoritos;
        this.pokemonInicial = pokemonInicial;
        this.senha = senha;
    }

    public Integer getId() {
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTiposFavoritos() {
        return tiposFavoritos;
    }

    public void setTiposFavoritos(String tiposFavoritos) {
        this.tiposFavoritos = tiposFavoritos;
    }

    public String getPokemonInicial() {
        return pokemonInicial;
    }

    public void setPokemonInicial(String pokemonInicial) {
        this.pokemonInicial = pokemonInicial;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
