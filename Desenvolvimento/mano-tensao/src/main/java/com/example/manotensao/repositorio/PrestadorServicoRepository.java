package com.example.manotensao.repositorio;

import com.example.manotensao.dominio.PrestadorServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PrestadorServicoRepository extends JpaRepository<PrestadorServico,Integer> {

    @Query("select ps from PrestadorServico ps " +
            "order by (select avg(aps.notaPrestadorServico) from AvaliacaoPrestadorServico aps where " +
            " aps.Proposta.PrestadorServico = ps)")
    Optional<List<PrestadorServico>> getPrestadorPorAvaliacao();

    @Query("select avg(aps.notaPrestadorServico) from AvaliacaoPrestadorServico aps" +
            " where aps.Proposta.PrestadorServico.id = ?1")
    Optional<Double> getNota(int id);

    // avg(am.nota)
    Optional<List<PrestadorServico>> findByFkServico(int servico);
}
