package com.example.manotensao.controle;

import com.example.manotensao.PilhaObjAvaliacaoCliente;
import com.example.manotensao.dominio.AvaliacaoCliente;
import com.example.manotensao.repositorio.AvaliacaoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes-usuarios")
@CrossOrigin(origins = "https://3.85.249.208:3000/")
public class AvaliacaoClienteController{

    @Autowired
    private AvaliacaoClienteRepository avaliacaoClienteRepository;

    PilhaObjAvaliacaoCliente<AvaliacaoCliente> pilhaAvaliacaoCliente = new PilhaObjAvaliacaoCliente<>(30);
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

    @DeleteMapping("/delete-avaliacao-cliente/{idAvaliacaoCliente}")
    public ResponseEntity deleteAvaliacaoCliente(@PathVariable Integer idAvaliacaoCliente){
        AvaliacaoCliente ac = avaliacaoClienteRepository.getById(idAvaliacaoCliente);
        pilhaAvaliacaoCliente.push(ac);
        avaliacaoClienteRepository.delete(ac);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/desfazer-avaliacao-cliente")
    public ResponseEntity desfazerAvaliacaoCliente(){
        AvaliacaoCliente ac = pilhaAvaliacaoCliente.peek();
        ac.setIdAvaliacao(pilhaAvaliacaoCliente.peek().getIdAvaliacao());
        avaliacaoClienteRepository.save(ac);
        pilhaAvaliacaoCliente.pop();
        return ResponseEntity.ok().build();
    }


}
