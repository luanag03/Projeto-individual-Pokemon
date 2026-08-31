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
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        String sql = "SELECT * FROM usuario";
        List<Usuario> usuarios = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Usuario.class));

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id) {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        List<Usuario> usuarios = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Usuario.class), id);

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(usuarios.get(0));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Void> cadastrar(@Valid @RequestBody Usuario novoUsuario) {
        String sql = "INSERT INTO usuario (nome, nickname, email, idade, data_nascimento, sexo, tipos_favoritos, pokemon_inicial, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                novoUsuario.getNome(),
                novoUsuario.getNickname(),
                novoUsuario.getEmail(),
                novoUsuario.getIdade(),
                novoUsuario.getDataNascimento(),
                novoUsuario.getSexo(),
                novoUsuario.getTiposFavoritos(),
                novoUsuario.getPokemonInicial(),
                novoUsuario.getSenha()
        );

        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";

        List<Usuario> usuarios = jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Usuario.class),
                usuario.getEmail(),
                usuario.getSenha()
        );

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(usuarios.get(0));
    }
}