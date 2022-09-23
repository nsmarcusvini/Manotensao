package com.example.manotensao.controle;

import com.example.manotensao.dominio.Plano;
import com.example.manotensao.repositorio.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    @Autowired
    private PlanoRepository planoRepository;

    @GetMapping
    public ResponseEntity<List<Plano>> get(){
        List<Plano> lista = planoRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }


    @PostMapping
    public ResponseEntity<Plano> post(@RequestBody Plano novoPlano){
        planoRepository.save(novoPlano);
        return ResponseEntity.status(201).body(novoPlano);
    }
}
