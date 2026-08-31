package com.projetoindividual.pokemon;

public class Pokemon {
    private Integer idPokemon;
    private String nome;
    private String tipo;
    private String descricao;

    public Pokemon() {
    }

    public Pokemon(Integer idPokemon, String nome, String tipo, String descricao) {
        this.idPokemon = idPokemon;
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Integer getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(Integer idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
