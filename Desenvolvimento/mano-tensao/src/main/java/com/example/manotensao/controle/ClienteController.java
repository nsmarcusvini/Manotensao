package com.example.manotensao.controle;

import com.example.manotensao.dominio.Cliente;
import com.example.manotensao.dominio.PrestadorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.manotensao.repositorio.ClienteRepository;
import com.example.manotensao.dto.CartaApresentacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController{

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/autenticacao-cliente/{email}/{senha}")
    public ResponseEntity<Cliente> login(@PathVariable String email, @PathVariable String senha){
        List<Cliente> lista = clienteRepository.findAll();
        for (Cliente cliente : lista) {
            if (cliente.autenticar(email,senha)) {
                cliente.setAutenticado(1);
                clienteRepository.save(cliente);
                return ResponseEntity.ok().body(cliente);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/logoff-cliente/{id}")
    public ResponseEntity<Void> logoff(@PathVariable int id){
        List<Cliente> lista = clienteRepository.findAll();
        for (Cliente cliente : lista) {
            if (cliente.getId().equals(id)) {
                cliente.setAutenticado(0);
                clienteRepository.save(cliente);
                return ResponseEntity.status(204).build();
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
        novoUsuario.setAutenticado(1);
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

    public CartaApresentacao lerArquivoTxt(String nomeArq) {
        System.out.println("Achei o arquivo!");
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String nome, email, telefone, apresentacao;
        CartaApresentacao carta = null;

        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            erro.printStackTrace();
        }
        try {
            registro = entrada.readLine();
            while (registro != null) {
                tipoRegistro = registro.substring(0, 2);
                if (tipoRegistro.equals("02")) {
                    nome = registro.substring(2, 46).trim();
                    email = registro.substring(47, 91).trim();
                    telefone = registro.substring(92, 106).trim();
                    apresentacao = registro.substring(107, 361).trim();
                    carta = new CartaApresentacao(nome, email, telefone, apresentacao);
                }
                registro = entrada.readLine();
            }
            entrada.close();
        } catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo");
            erro.printStackTrace();
        }
        return carta;
    }

    @PutMapping("/receber-apresentacao")
    public ResponseEntity<CartaApresentacao> apresentacao(@RequestParam int idCliente,
                                                          @RequestParam String nomeArq) {
        CartaApresentacao carta = lerArquivoTxt(nomeArq);
        List<Cliente> lista = clienteRepository.findAll();
        for (Cliente cliente : lista) {
            if (cliente.getId().equals(idCliente)) {
                cliente.setCartaApresentacao(carta.getApresentacao());
                put(idCliente, cliente);
            }
        }
        return ResponseEntity.status(200).body(carta);
    }

}
