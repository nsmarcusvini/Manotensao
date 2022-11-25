package com.example.manotensao.controle;

import com.example.manotensao.dominio.AvaliacaoPrestadorServico;
import com.example.manotensao.repositorio.AvaliacaoPrestadorServicoRepository;
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

@SpringBootTest(classes = AvaliacaoPrestadorServicoController.class)
class AvaliacaoPrestadorServicoControllerTest {

    @Autowired
    AvaliacaoPrestadorServicoController controller;

    @MockBean
    AvaliacaoPrestadorServicoRepository repository;

    @Test
    @DisplayName(
            "get deve retornar 204 e sem corpo caso tabela vazia")
    void get204SemCorpo() {
        when(repository.findAll())
                .thenReturn(new ArrayList<>());

        ResponseEntity<List<AvaliacaoPrestadorServico>> resposta;
        resposta = controller.get();

        assertEquals(204, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());
    }

    @Test
    @DisplayName(
            "get deve retornar 200 e com corpo caso tabela com dados")
    void get200ComCorpo() {
        List<AvaliacaoPrestadorServico> lista = List.of(
                mock(AvaliacaoPrestadorServico.class),
                mock(AvaliacaoPrestadorServico.class)
        );

        when(repository.findAll()).thenReturn(lista);

        ResponseEntity<List<AvaliacaoPrestadorServico>> resposta
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

        ResponseEntity<AvaliacaoPrestadorServico> resposta = controller.put(idTeste,
                mock(AvaliacaoPrestadorServico.class));

        assertEquals(404, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());
    }

    @Test
    @DisplayName("put deve retornar 200 e com corpo válido caso id exista")
    void put200ComCorpo() {
        Integer idTeste = 11;
        AvaliacaoPrestadorServico avaliacaoPrestadorServico = new AvaliacaoPrestadorServico();
        when(repository.existsById(idTeste)).thenReturn(true);

        ResponseEntity<AvaliacaoPrestadorServico> resposta = controller.put(idTeste, avaliacaoPrestadorServico);

        verify(repository, times(1)).save(avaliacaoPrestadorServico);
        assertEquals(200, resposta.getStatusCodeValue());
        assertNotNull(resposta.getBody());
        assertEquals(idTeste, resposta.getBody().getIdAvaliacaoPrestador());
    }
}