package com.example.manotensao.controle;

import com.example.manotensao.dominio.Plano;
import com.example.manotensao.repositorio.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")
@CrossOrigin(origins = "http://3.215.198.136:3000/")
public class PlanoController{

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if(planoRepository.existsById(id)){
            planoRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plano> put(@PathVariable int id, @RequestBody Plano plano){
        if(planoRepository.existsById(id)){
            plano.setIdPlano(id);
            planoRepository.save(plano);
            return ResponseEntity.status(200).body(plano);
        }
        return ResponseEntity.status(404).build();
    }
}
