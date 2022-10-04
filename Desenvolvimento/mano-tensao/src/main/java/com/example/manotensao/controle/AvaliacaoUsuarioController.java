package com.example.manotensao.controle;

import com.example.manotensao.dominio.AvaliacaoUsuario;
import com.example.manotensao.dominio.Plano;
import com.example.manotensao.repositorio.AvaliacaoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes-usuarios")
public class AvaliacaoUsuarioController {

    @Autowired
    private AvaliacaoUsuarioRepository avaliacaoUsuarioRepository;

    @GetMapping
    public ResponseEntity<List<AvaliacaoUsuario>> get(){
        List<AvaliacaoUsuario> lista = avaliacaoUsuarioRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }


    @PostMapping
    public ResponseEntity<AvaliacaoUsuario> post(@RequestBody AvaliacaoUsuario novaAvaliacaoUsuario){
        avaliacaoUsuarioRepository.save(novaAvaliacaoUsuario);
        return ResponseEntity.status(201).body(novaAvaliacaoUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if(avaliacaoUsuarioRepository.existsById(id)){
            avaliacaoUsuarioRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoUsuario> put(@PathVariable int id, @RequestBody AvaliacaoUsuario avaliacao){
        if(avaliacaoUsuarioRepository.existsById(id)){
            avaliacao.setIdAvaliacao(id);
            avaliacaoUsuarioRepository.save(avaliacao);
            return ResponseEntity.status(200).body(avaliacao);
        }
        return ResponseEntity.status(404).build();
    }
}
