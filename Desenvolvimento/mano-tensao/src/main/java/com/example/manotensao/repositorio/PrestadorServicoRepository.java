package com.example.manotensao.repositorio;

import com.example.manotensao.DTO.CartaApresentacao;
import com.example.manotensao.DTO.FiltroPorAvaliacao;
import com.example.manotensao.DTO.PropostaCSV;
import com.example.manotensao.dominio.PrestadorServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PrestadorServicoRepository extends JpaRepository<PrestadorServico,Integer>{
    Optional<List<PrestadorServico>> findByFkServico(int servico);

    @Query("select new com.example.manotensao.DTO.CartaApresentacao(ps.nome, ps.email, ps.telefone, ps.cartaApresentacao) " +
            "from PrestadorServico ps " +
            "where ps.idPrestador = ?1")
    CartaApresentacao getCartaApresentacao(int idPrestador);
}
