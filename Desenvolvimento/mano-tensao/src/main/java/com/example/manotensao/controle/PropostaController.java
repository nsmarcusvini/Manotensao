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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if(propostaRepository.existsById(id)){
            propostaRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proposta> put(@PathVariable int id, @RequestBody Proposta proposta){
        if(propostaRepository.existsById(id)){
            proposta.setIdProposta(id);
            propostaRepository.save(proposta);
            return ResponseEntity.status(200).body(proposta);
        }
        return ResponseEntity.status(404).build();
    }

}
