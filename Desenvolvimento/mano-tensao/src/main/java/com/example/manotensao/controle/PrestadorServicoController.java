package com.example.manotensao.controle;

import com.example.manotensao.dto.CartaApresentacao;
import com.example.manotensao.dominio.PrestadorServico;
import com.example.manotensao.dto.FiltroPorAvaliacao;
import com.example.manotensao.repositorio.PrestadorServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/prestadores")
public class PrestadorServicoController {

    @Autowired
    private PrestadorServicoRepository prestadorServicoRepository;

    @PostMapping("/autenticacao-prestador/{email}/{senha}")
    public ResponseEntity<PrestadorServico> login(@PathVariable String email, @PathVariable String senha) {
        List<PrestadorServico> lista = prestadorServicoRepository.findAll();
        for (PrestadorServico prestador : lista) {
            if (prestador.autenticar(email, senha)) {
                prestador.setAutenticado(1);
                prestadorServicoRepository.save(prestador);
                return ResponseEntity.ok().body(prestador);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/logoff-prestador/{id}")
    public ResponseEntity<Void> logoff(@PathVariable int id) {
        List<PrestadorServico> lista = prestadorServicoRepository.findAll();
        for (PrestadorServico prestador : lista) {
            if (prestador.getId().equals(id)) {
                prestador.setAutenticado(0);
                prestadorServicoRepository.save(prestador);
                return ResponseEntity.status(204).build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<PrestadorServico>> get() {
        List<PrestadorServico> lista = prestadorServicoRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/filtro-por-servico/{idServico}/{segundaVariacao}/{terceiraVariacao}/{quartaVariacao}")
    public ResponseEntity<List<FiltroPorAvaliacao>> get(@PathVariable int idServico, @PathVariable int segundaVariacao,
                                                      @PathVariable int terceiraVariacao, @PathVariable int quartaVariacao) {
        List<FiltroPorAvaliacao> lista = prestadorServicoRepository.getPrestadorPorServico(idServico,segundaVariacao,terceiraVariacao,quartaVariacao);
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

    @PostMapping
    public ResponseEntity<PrestadorServico> post(@RequestBody PrestadorServico novoPrestador) {
        novoPrestador.setAutenticado(1);
        prestadorServicoRepository.save(novoPrestador);
        return ResponseEntity.status(201).body(novoPrestador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (prestadorServicoRepository.existsById(id)) {
            prestadorServicoRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestadorServico> put(@PathVariable int id, @RequestBody PrestadorServico prestador) {
        if (prestadorServicoRepository.existsById(id)) {
            prestador.setId(id);
            prestadorServicoRepository.save(prestador);
            return ResponseEntity.status(200).body(prestador);
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

    public static void gerarBoleto(PrestadorServico prestador, String nomeArq) {
        String header = "00BOLETOS";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        gravaRegistro(header, nomeArq);

        String corpo = "02";
        corpo += String.format("%-45.45s", prestador.getNome());
        corpo += String.format("%-14.14s", prestador.getCpf());
        corpo += String.format("%-10.10s", prestador.getDtNascimento());
        corpo += String.format("%-9.9s", prestador.getCep());
        corpo += String.format("%04d", prestador.getNumero());
        corpo += String.format("%-45.45s", prestador.getComplemento());
        corpo += String.format("%-15.15s", prestador.getTelefone());
        corpo += String.format("%-30.30s", prestador.getFkPlano().getTipoPlano());
        corpo += String.format("%06.2f", prestador.getFkPlano().getValorPlano());

        gravaRegistro(corpo, nomeArq);

        String trailer = "010205";
        gravaRegistro(trailer, nomeArq);
    }

    public static void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        try {
            saida = new BufferedWriter(new FileWriter(nomeArq,true));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            erro.printStackTrace();
        }

        try {
            saida.append(registro + "\n");
            saida.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo");
            erro.printStackTrace();
        }
    }

    @GetMapping("/carta-apresentacao/{idPrestador}")
    public ResponseEntity<CartaApresentacao> cartaApresentacao(@PathVariable int idPrestador) {
        CartaApresentacao carta = prestadorServicoRepository.getCartaApresentacao(idPrestador);
        return carta.getApresentacao() != null ? ResponseEntity.status(200).body(carta) :
                ResponseEntity.status(404).build();
    }

    @GetMapping("/gerar-boleto/{idPrestador}")
    public ResponseEntity<PrestadorServico> boletoTxt(@PathVariable int idPrestador) {
        PrestadorServico prestadorServico = null;
        List<PrestadorServico> lista = prestadorServicoRepository.findAll();
        for (PrestadorServico prestador : lista) {
            if (prestador.getId().equals(idPrestador)) {
                prestadorServico = prestador;
            }
        }
        if(prestadorServico != null){
            String nomeArq = "Boleto_" + prestadorServico.getNome() + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            gerarBoleto(prestadorServico, nomeArq);
        } else{
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(prestadorServico);
    }

    @PutMapping("/receber-apresentacao")
    public ResponseEntity<CartaApresentacao> apresentacao(@RequestParam int idPrestador,
                                                          @RequestParam String nomeArq) {
        CartaApresentacao carta = lerArquivoTxt(nomeArq);
        List<PrestadorServico> lista = prestadorServicoRepository.findAll();
        for (PrestadorServico prestador : lista) {
            if (prestador.getId().equals(idPrestador)) {
                prestador.setCartaApresentacao(carta.getApresentacao());
                put(idPrestador, prestador);
            }
        }
        return ResponseEntity.status(200).body(carta);
    }

    @GetMapping("/quantidade-propostas/{idPrestador}")
    public ResponseEntity<Integer> getPropostasNoUltimoMes(@PathVariable int idPrestador){
        return ResponseEntity.status(200).body(prestadorServicoRepository.getPropostasNoUltimoMes(idPrestador));
    }
}
