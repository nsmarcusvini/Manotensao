package com.example.manotensao.controle;

import com.example.manotensao.FilaObjProposta;
import com.example.manotensao.dto.PropostaCSV;
import com.example.manotensao.dominio.Proposta;
import com.example.manotensao.repositorio.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

    @Autowired
    private PropostaRepository propostaRepository;

    FilaObjProposta<Proposta> filaProposta = new FilaObjProposta<>(30);
    @GetMapping
    public ResponseEntity<List<Proposta>> get() {
        List<Proposta> lista = propostaRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

    @PostMapping
    public ResponseEntity<Proposta> post(@RequestBody Proposta novaProposta) {
        propostaRepository.save(novaProposta);
        return ResponseEntity.status(201).body(novaProposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (propostaRepository.existsById(id)) {
            propostaRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proposta> put(@PathVariable int id, @RequestBody Proposta proposta) {
        if (propostaRepository.existsById(id)) {
            proposta.setIdProposta(id);
            propostaRepository.save(proposta);
            return ResponseEntity.status(200).body(proposta);
        }
        return ResponseEntity.status(404).build();
    }

    public void gravaArquivoCSV(List<PropostaCSV> lista) {
        FileWriter arq = null;
        Formatter saida = null;
        boolean error = false;
        String nomeArq = "propostas.csv";

        try {
            arq = new FileWriter(nomeArq);
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        try {
            saida.format("Nome do cliente;Quantidade de dias;Quantidade de horas;Valor total;Bairro;Rua\n");
            for (int i = 0; i < lista.size(); i++) {
                PropostaCSV p = lista.get(i);
                saida.format("%s;%d;%.2f;%.2f;%s;%s\n", p.getNomeCliente(), p.getQtdDias(), p.getQtdHoras(),
                        p.getValorTotal(), p.getBairro(), p.getRua());
            }
        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            erro.printStackTrace();
            error = true;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                error = true;
            }
            if (error) {
                System.exit(1);
            }
        }
    }

    @GetMapping("/download-csv/{idPrestador}")
    public ResponseEntity<List<PropostaCSV>> propostasAceitas(@PathVariable int idPrestador) {
        List<PropostaCSV> lista = propostaRepository.testeCsv(idPrestador);
        gravaArquivoCSV(lista);
        return lista.isEmpty() ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/propostas-salvas")
    public ResponseEntity<List<Proposta>> getListarPropostas() {
        List<Proposta> listaPropostas = propostaRepository.findAll();

        for (Proposta p : listaPropostas) {
            if (p.getPropostaAceita().equals(0))
            filaProposta.insert(p);
            else {
                return ResponseEntity.status(204).build();
            }
        }
        return ResponseEntity.status(200).body(listaPropostas);
    }

}
