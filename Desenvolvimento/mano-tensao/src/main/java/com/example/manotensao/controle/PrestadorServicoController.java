package com.example.manotensao.controle;

import com.example.manotensao.dominio.PrestadorServico;
import com.example.manotensao.repositorio.PrestadorServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestadores")
public class PrestadorServicoController {

    @Autowired
    private PrestadorServicoRepository prestadorServicoRepository;

    @GetMapping
    public ResponseEntity<List<PrestadorServico>> get(){
        List<PrestadorServico> lista = prestadorServicoRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }


    @PostMapping
    public ResponseEntity<PrestadorServico> post(@RequestBody PrestadorServico novoPrestador){
        prestadorServicoRepository.save(novoPrestador);
        return ResponseEntity.status(201).body(novoPrestador);
    }
}
