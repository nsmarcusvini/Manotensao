package com.example.manotensao.repositorio;

import com.example.manotensao.dto.CartaApresentacao;
import com.example.manotensao.dominio.PrestadorServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PrestadorServicoRepository extends JpaRepository<PrestadorServico, Integer>{
    Optional<List<PrestadorServico>> findByFkServico(int servico);

    @Query("select new com.example.manotensao.dto.CartaApresentacao(ps.nome, ps.email, ps.telefone, ps.cartaApresentacao) " +
            "from PrestadorServico ps " +
            "where ps.idPrestador = ?1")
    CartaApresentacao getCartaApresentacao(int idPrestador);

    @Query("select count(id_proposta) from Proposta p " +
            "join p.fkPrestadorServico ps " +
            "where ps.idPrestador = ?1 and Month(data_proposta) = Month(GETDATE())")
    Integer getPropostasNoUltimoMes(int idPrestador);
}
