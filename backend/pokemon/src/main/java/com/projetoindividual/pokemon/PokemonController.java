package com.projetoindividual.pokemon;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public ResponseEntity<List<Pokemon>> listar() {
        String sql = "SELECT * FROM pokemon";
        List<Pokemon> pokemons = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Pokemon.class));

        if (pokemons.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(pokemons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> buscarPorId(@PathVariable Integer id) {
        String sql = "SELECT * FROM pokemon WHERE idPokemon = ?";
        List<Pokemon> pokemons = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Pokemon.class), id);

        if (pokemons.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(pokemons.get(0));
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@Valid @RequestBody Pokemon novoPokemon) {
        String sql = "INSERT INTO pokemon (nome, tipo, descricao) VALUES (?, ?, ?)";

        jdbcTemplate.update(
                sql,
                novoPokemon.getNome(),
                novoPokemon.getTipo(),
                novoPokemon.getDescricao()
        );

        return ResponseEntity.status(201).build();
    }
}