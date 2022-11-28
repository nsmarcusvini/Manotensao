package com.example.manotensao.controle;

import com.example.manotensao.dominio.ChatCliente;
import com.example.manotensao.dominio.ChatPrestador;
import com.example.manotensao.repositorio.ChatPrestadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat-prestador")
public class ChatPrestadorController {

    @Autowired
    private ChatPrestadorRepository chatPrestadorRepository;

    @GetMapping
    public ResponseEntity<List<ChatPrestador>> get(){
        List<ChatPrestador> lista = chatPrestadorRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

    @PostMapping
    public ResponseEntity<ChatPrestador> post(@RequestBody ChatPrestador novaMensagem){
        chatPrestadorRepository.save(novaMensagem);
        return ResponseEntity.status(201).body(novaMensagem);
    }
}
