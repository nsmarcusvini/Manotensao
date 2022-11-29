package com.example.manotensao.controle;

import com.example.manotensao.PilhaObj;
import com.example.manotensao.dominio.AvaliacaoCliente;
import com.example.manotensao.dominio.Proposta;
import com.example.manotensao.repositorio.AvaliacaoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes-usuarios")
public class AvaliacaoClienteController{

    @Autowired
    private AvaliacaoClienteRepository avaliacaoClienteRepository;

    PilhaObj<AvaliacaoCliente> pilhaAvaliacaoCliente = new PilhaObj<>(30);
    @GetMapping
    public ResponseEntity<List<AvaliacaoCliente>> get(){
        List<AvaliacaoCliente> lista = avaliacaoClienteRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }


    @PostMapping
    public ResponseEntity<AvaliacaoCliente> post(@RequestBody AvaliacaoCliente novaAvaliacaoUsuario){
        avaliacaoClienteRepository.save(novaAvaliacaoUsuario);
        return ResponseEntity.status(201).body(novaAvaliacaoUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if(avaliacaoClienteRepository.existsById(id)){
            avaliacaoClienteRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoCliente> put(@PathVariable int id, @RequestBody AvaliacaoCliente avaliacao){
        if(avaliacaoClienteRepository.existsById(id)){
            avaliacao.setIdAvaliacao(id);
            avaliacaoClienteRepository.save(avaliacao);
            return ResponseEntity.status(200).body(avaliacao);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/delete/{idAvaliacaoCliente}")
    public ResponseEntity deleteAvaliacaoCliente(@PathVariable Integer idAvaliacaoCliente){
        AvaliacaoCliente ac = avaliacaoClienteRepository.getById(idAvaliacaoCliente);
        pilhaAvaliacaoCliente.push(ac);
        avaliacaoClienteRepository.delete(ac);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/desfazer")
    public ResponseEntity desfazerAvaliacaoCliente(){
        AvaliacaoCliente ac = pilhaAvaliacaoCliente.peek();
        ac.setIdAvaliacao(pilhaAvaliacaoCliente.peek().getIdAvaliacao());
        avaliacaoClienteRepository.save(ac);
        pilhaAvaliacaoCliente.pop();
        return ResponseEntity.ok().build();
    }


}
