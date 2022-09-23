package com.example.manotensao.controle;

import com.example.manotensao.dominio.AvaliacaoPrestadorServico;
import com.example.manotensao.repositorio.AvaliacaoPrestadorServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes-prestadores")
public class AvaliacaoPrestadorServicoController {

    @Autowired
    private AvaliacaoPrestadorServicoRepository avaliacaoPrestadorServicoRepository;

    @GetMapping
    public ResponseEntity<List<AvaliacaoPrestadorServico>> get(){
        List<AvaliacaoPrestadorServico> lista = avaliacaoPrestadorServicoRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }


    @PostMapping
    public ResponseEntity<AvaliacaoPrestadorServico> post(@RequestBody AvaliacaoPrestadorServico novaAvaliacaoPrestador){
        avaliacaoPrestadorServicoRepository.save(novaAvaliacaoPrestador);
        return ResponseEntity.status(201).body(novaAvaliacaoPrestador);
    }

}
