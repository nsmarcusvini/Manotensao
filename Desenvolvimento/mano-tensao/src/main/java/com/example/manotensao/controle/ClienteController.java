package com.example.manotensao.controle;

import com.example.manotensao.dominio.Cliente;
import com.example.manotensao.dominio.PrestadorServico;
import com.example.manotensao.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/autenticacao-cliente")
    public ResponseEntity<Void> login(@RequestBody String email, @RequestBody String senha){
        List<Cliente> lista = clienteRepository.findAll();
        for (Cliente cliente : lista) {
            if (cliente.getEmail().equals(email)
                    && cliente.pegarSenha().equals(senha)) {
                cliente.setAutenticado(true);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/autenticacao-cliente")
    public ResponseEntity<Void> logoff(@RequestBody int id){
        List<Cliente> lista = clienteRepository.findAll();
        for (Cliente cliente : lista) {
            if (cliente.pegarId().equals(id)) {
                cliente.setAutenticado(false);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> get(){
        List<Cliente> lista = clienteRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

    @PostMapping
    public ResponseEntity<Cliente> post(@RequestBody Cliente novoUsuario){
        clienteRepository.save(novoUsuario);
        return ResponseEntity.status(201).body(novoUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> put(@PathVariable int id, @RequestBody Cliente cliente){
        if(clienteRepository.existsById(id)){
            cliente.setId(id);
            clienteRepository.save(cliente);
            return ResponseEntity.status(200).body(cliente);
        }
        return ResponseEntity.status(404).build();
    }

}