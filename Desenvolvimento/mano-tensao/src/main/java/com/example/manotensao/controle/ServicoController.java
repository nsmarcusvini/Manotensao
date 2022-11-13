package com.example.manotensao.controle;

import com.example.manotensao.dominio.Servico;
import com.example.manotensao.repositorio.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController{

    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping
    public ResponseEntity<List<Servico>> get(){
        List<Servico> lista = servicoRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

    @PostMapping
    public ResponseEntity<Servico> post(@RequestBody Servico novoServico){
        servicoRepository.save(novoServico);
        return ResponseEntity.status(201).body(novoServico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if(servicoRepository.existsById(id)){
            servicoRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> put(@PathVariable int id, @RequestBody Servico servico){
        if(servicoRepository.existsById(id)){
            servico.setIdTipoServico(id);
            servicoRepository.save(servico);
            return ResponseEntity.status(200).body(servico);
        }
        return ResponseEntity.status(404).build();
    }

}
