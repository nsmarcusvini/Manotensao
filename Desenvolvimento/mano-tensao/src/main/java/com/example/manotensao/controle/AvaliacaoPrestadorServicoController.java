package com.example.manotensao.controle;

import com.example.manotensao.PilhaObjAvaliacaoCliente;
import com.example.manotensao.PilhaObjAvaliacaoPrestador;
import com.example.manotensao.dominio.AvaliacaoCliente;
import com.example.manotensao.dto.FiltroPorAvaliacao;
import com.example.manotensao.dominio.AvaliacaoPrestadorServico;
import com.example.manotensao.repositorio.AvaliacaoPrestadorServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes-prestadores")
public class AvaliacaoPrestadorServicoController{

    @Autowired
    private AvaliacaoPrestadorServicoRepository avaliacaoPrestadorServicoRepository;

    PilhaObjAvaliacaoPrestador<AvaliacaoPrestadorServico> pilhaAvaliacaoPrestador = new PilhaObjAvaliacaoPrestador<>(30);
    @GetMapping("/melhores")
    public ResponseEntity<List<FiltroPorAvaliacao>> getFiltroAvaliacao(){
        List<FiltroPorAvaliacao> lista = avaliacaoPrestadorServicoRepository.getAvaliacoes();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/melhores-por-servico/{idServico}/{segundaVariacao}/{terceiraVariacao}/{quartaVariacao}")
    public ResponseEntity<List<FiltroPorAvaliacao>> getFiltroAvaliacaoPorServico(@PathVariable int idServico, @PathVariable int segundaVariacao,
                                                                                 @PathVariable int terceiraVariacao, @PathVariable int quartaVariacao){
        List<FiltroPorAvaliacao> lista = avaliacaoPrestadorServicoRepository.getAvaliacoesPorServico(idServico,segundaVariacao,terceiraVariacao,quartaVariacao);
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoPrestadorServico>> get(){
        List<AvaliacaoPrestadorServico> lista = avaliacaoPrestadorServicoRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }


    @PostMapping
    public ResponseEntity<AvaliacaoPrestadorServico> post(@RequestBody AvaliacaoPrestadorServico novaAvaliacaoPrestador){
        avaliacaoPrestadorServicoRepository.save(novaAvaliacaoPrestador);
        return ResponseEntity.status(201).body(novaAvaliacaoPrestador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if(avaliacaoPrestadorServicoRepository.existsById(id)){
            avaliacaoPrestadorServicoRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoPrestadorServico> put(@PathVariable int id, @RequestBody AvaliacaoPrestadorServico avaliacao){
        if(avaliacaoPrestadorServicoRepository.existsById(id)){
            avaliacao.setIdAvaliacaoPrestador(id);
            avaliacaoPrestadorServicoRepository.save(avaliacao);
            return ResponseEntity.status(200).body(avaliacao);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/delete-avaliacao-prestador/{idAvaliacaoPrestador}")
    public ResponseEntity deleteAvaliacaoPrestador(@PathVariable Integer idAvaliacaoPrestador){
        AvaliacaoPrestadorServico aps = avaliacaoPrestadorServicoRepository.getById(idAvaliacaoPrestador);
        pilhaAvaliacaoPrestador.push(aps);
        avaliacaoPrestadorServicoRepository.delete(aps);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/desfazer-avaliacao-prestador")
    public ResponseEntity desfazerAvaliacaoPrestador(){
        AvaliacaoPrestadorServico aps = pilhaAvaliacaoPrestador.peek();
        aps.setIdAvaliacaoPrestador(pilhaAvaliacaoPrestador.peek().getIdAvaliacaoPrestador());
        avaliacaoPrestadorServicoRepository.save(aps);
        pilhaAvaliacaoPrestador.pop();
        return ResponseEntity.ok().build();
    }


}
