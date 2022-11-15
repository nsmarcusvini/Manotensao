package com.example.manotensao.controle;

import com.example.manotensao.DTO.CartaApresentacao;
import com.example.manotensao.dominio.PrestadorServico;
import com.example.manotensao.repositorio.PrestadorServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prestadores")
public class PrestadorServicoController {

    @Autowired
    private PrestadorServicoRepository prestadorServicoRepository;

    @GetMapping("/autenticacao-prestador")
    public ResponseEntity<Void> login(@RequestBody String email, @RequestBody String senha) {
        List<PrestadorServico> lista = prestadorServicoRepository.findAll();
        for (PrestadorServico prestador : lista) {
            if (prestador.autenticar(email, senha)) {
                prestador.setAutenticado(true);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/autenticacao-prestador")
    public ResponseEntity<Void> logoff(@RequestBody int id) {
        List<PrestadorServico> lista = prestadorServicoRepository.findAll();
        for (PrestadorServico prestador : lista) {
            if (prestador.pegarId().equals(id)) {
                prestador.setAutenticado(false);
                return ResponseEntity.ok().build();
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

    @PostMapping
    public ResponseEntity<PrestadorServico> post(@RequestBody PrestadorServico novoPrestador) {
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
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String nome, email, telefone, apresentacao;
        CartaApresentacao carta = null;
        int contaRegDadoLido = 0;
        int qtdRegDadoGravado;

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
                if (tipoRegistro.equals("00")) {
                    System.out.println("Registro de header");
                    System.out.println("Tipo de arquivo: " + registro.substring(2, 6));
                    System.out.println("Ano e semestre: " + registro.substring(6, 11));
                    System.out.println("Data e hora da gravação: " + registro.substring(11, 30));
                    System.out.println("Versão do documento: " + registro.substring(30, 32));
                } else if (tipoRegistro.equals("01")) {
                    System.out.println("Registro de trailer");
                    qtdRegDadoGravado = Integer.parseInt(registro.substring(2, 12));
                    System.out.println("Quantidade de reg de dados lidos: " + contaRegDadoLido);
                    System.out.println("Quantidade de reg de dados gravados: " + qtdRegDadoGravado);
                    if (contaRegDadoLido == qtdRegDadoGravado) {
                        System.out.println("Quantidade de registros de dados lidos compatível com "
                                + "quantidade de registros de dados gravados");
                    } else {
                        System.out.println("Quantidade de registros de dados lidos incompatível com "
                                + "quantidade de registros de dados gravados");
                    }
                } else if (tipoRegistro.equals("02")) {
                    System.out.println("Registro de corpo");
                    nome = registro.substring(2, 46).trim();
                    email = registro.substring(47, 91).trim();
                    telefone = registro.substring(92, 106).trim();
                    apresentacao = registro.substring(107, 361).trim();
                    contaRegDadoLido++;


                    carta = new CartaApresentacao(nome, email, telefone, apresentacao);


                } else {
                    System.out.println("Tipo de registro inválido!");
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

    @GetMapping("/carta-apresentacao/{idPrestador}")
    public ResponseEntity<CartaApresentacao> cartaApresentacao(@PathVariable int idPrestador) {
        CartaApresentacao carta = prestadorServicoRepository.getCartaApresentacao(idPrestador);
        return carta.getApresentacao() != null ? ResponseEntity.status(200).body(carta) :
                ResponseEntity.status(404).build();
    }

    @PutMapping("/receber-apresentacao")
    public ResponseEntity<CartaApresentacao> apresentacao(@RequestParam int idPrestador,
                                                          @RequestParam String nomeArq) {
        CartaApresentacao carta = lerArquivoTxt(nomeArq);
        PrestadorServico prestador = prestadorServicoRepository.getReferenceById(idPrestador);
        prestador.setCartaApresentacao(carta.getApresentacao());
        put(idPrestador, prestador);
        return ResponseEntity.status(200).body(carta);
    }
}
