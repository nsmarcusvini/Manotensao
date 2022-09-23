package com.example.manotensao.controle;

import com.example.manotensao.dominio.Usuario;
import com.example.manotensao.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> get(){
        List<Usuario> lista = usuarioRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }


    @PostMapping
    public ResponseEntity<Usuario> post(@RequestBody Usuario novoUsuario){
        usuarioRepository.save(novoUsuario);
        return ResponseEntity.status(201).body(novoUsuario);
    }

}
