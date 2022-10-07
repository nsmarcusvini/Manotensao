package com.example.manotensao.controle;

import com.example.manotensao.dominio.Cliente;
import com.example.manotensao.dominio.PrestadorServico;
import com.example.manotensao.dominio.Proposta;
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
    public ResponseEntity<Void> autenticar(@RequestBody String email, @RequestBody String senha){
        List<PrestadorServico> lista = prestadorServicoRepository.findAll();
        if(lista.stream().anyMatch(prestadorServico -> prestadorServico.autenticar(email,senha))){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if(prestadorServicoRepository.existsById(id)){
            prestadorServicoRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestadorServico> put(@PathVariable int id, @RequestBody PrestadorServico prestador){
        if(prestadorServicoRepository.existsById(id)){
            prestador.setIdPrestador(id);
            prestadorServicoRepository.save(prestador);
            return ResponseEntity.status(200).body(prestador);
        }
        return ResponseEntity.status(404).build();
    }
}
