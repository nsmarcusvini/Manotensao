package com.example.manotensao.controle;

import ch.qos.logback.core.net.server.Client;
import com.example.manotensao.dominio.Cliente;
import com.example.manotensao.dominio.Plano;
import com.example.manotensao.repositorio.ClienteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest(classes = ClienteController.class)
class ClienteControllerTest {
    @Autowired
    ClienteController controller;

    @MockBean
    ClienteRepository repository;

    @Test
    @DisplayName(
            "get deve retornar 204 e sem corpo caso tabela vazia")
    void get204SemCorpo() {
        when(repository.findAll())
                .thenReturn(new ArrayList<>());

        ResponseEntity<List<Cliente>> resposta
                = controller.get();

        assertEquals(204, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());
    }

    @Test
    @DisplayName(
            "get deve retornar 200 e com corpo caso tabela com dados")
    void get200ComCorpo() {
        List<Cliente> lista = List.of(
                mock(Cliente.class),
                mock(Cliente.class)
        );

        when(repository.findAll()).thenReturn(lista);

        ResponseEntity<List<Cliente>> resposta
                = controller.get();

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(lista, resposta.getBody());
    }
    @Test
    @DisplayName("delete deve retornar 200 e sem corpo caso id exista")
    void delete200SemCorpo() {
        Integer idTeste = 11;
        when(repository.existsById(idTeste)).thenReturn(true);

        ResponseEntity<Void> resposta = controller.delete(idTeste);

        verify(repository, times(1)).deleteById(idTeste);
        assertEquals(200, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());

    }

    @Test
    @DisplayName(
            "delete deve retornar 404 e sem corpo caso id não exista")
    void delete404SemCorpo() {
        Integer idTeste = 51;
        when(repository.existsById(idTeste)).thenReturn(false);

        ResponseEntity<Void> resposta =
                controller.delete(idTeste);

        assertEquals(404, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());
    }

    @Test
    @DisplayName(
            "put deve retornar 404 e sem corpo caso id não exista")
    void put404SemCorpo() {
        Integer idTeste = 51;
        when(repository.existsById(idTeste)).thenReturn(false);

        ResponseEntity<Cliente> resposta = controller.put(idTeste, mock(Cliente.class));

        assertEquals(404, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());
    }

    @Test
    @DisplayName("put deve retornar 200 e com corpo válido caso id exista")
    void put200ComCorpo() {
        Integer idTeste = 11;
        Cliente cliente = new Cliente();
        when(repository.existsById(idTeste)).thenReturn(true);

        ResponseEntity<Cliente> resposta = controller.put(idTeste, cliente);

        verify(repository, times(1)).save(cliente);
        assertEquals(200, resposta.getStatusCodeValue());
        assertNotNull(resposta.getBody());
        assertEquals(idTeste, resposta.getBody().pegarId());
    }
}