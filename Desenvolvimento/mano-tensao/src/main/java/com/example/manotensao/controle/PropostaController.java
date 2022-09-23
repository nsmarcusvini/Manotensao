package com.example.manotensao.controle;

import com.example.manotensao.dominio.Proposta;
import com.example.manotensao.repositorio.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

    @Autowired
    private PropostaRepository propostaRepository;

    @GetMapping
    public ResponseEntity<List<Proposta>> get(){
        List<Proposta> lista = propostaRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }


    @PostMapping
    public ResponseEntity<Proposta> post(@RequestBody Proposta novaProposta){
        propostaRepository.save(novaProposta);
        return ResponseEntity.status(201).body(novaProposta);
    }

}
