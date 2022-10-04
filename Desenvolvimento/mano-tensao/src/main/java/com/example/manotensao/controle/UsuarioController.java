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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> put(@PathVariable int id, @RequestBody Usuario usuario){
        if(usuarioRepository.existsById(id)){
            usuario.setIdUsuario(id);
            usuarioRepository.save(usuario);
            return ResponseEntity.status(200).body(usuario);
        }
        return ResponseEntity.status(404).build();
    }

}
