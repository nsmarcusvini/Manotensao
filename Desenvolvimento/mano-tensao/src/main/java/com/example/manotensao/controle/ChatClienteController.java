package com.example.manotensao.controle;

import com.example.manotensao.dominio.ChatCliente;
import com.example.manotensao.repositorio.ChatClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat-cliente")
public class ChatClienteController {

    @Autowired
    private ChatClienteRepository chatClienteRepository;

    @GetMapping
    public ResponseEntity<List<ChatCliente>> get(){
        List<ChatCliente> lista = chatClienteRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

    @PostMapping
    public ResponseEntity<ChatCliente> post(@RequestBody ChatCliente novaMensagem){
        chatClienteRepository.save(novaMensagem);
        return ResponseEntity.status(201).body(novaMensagem);
    }

}
