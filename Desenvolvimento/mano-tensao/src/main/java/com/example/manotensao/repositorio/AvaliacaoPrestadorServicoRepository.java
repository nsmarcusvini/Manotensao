package com.example.manotensao.repositorio;

import com.example.manotensao.dto.FiltroPorAvaliacao;
import com.example.manotensao.dominio.AvaliacaoPrestadorServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvaliacaoPrestadorServicoRepository extends JpaRepository<AvaliacaoPrestadorServico, Integer>{
    @Query("select new com.example.manotensao.dto.FiltroPorAvaliacao(ps.nome, ps.email, ps.urlFoto, ps.telefone, avg(aps.notaPrestadorServico), ps.cep) from AvaliacaoPrestadorServico aps " +
            "join aps.fkProposta p " +
            "join p.fkPrestadorServico ps " +
            "GROUP BY ps.nome, ps.email, ps.urlFoto, ps.telefone " +
            "ORDER BY avg(aps.notaPrestadorServico) desc")
    List<FiltroPorAvaliacao> getAvaliacoes();

    @Query("select new com.example.manotensao.dto.FiltroPorAvaliacao(ps.nome, ps.email, ps.urlFoto, ps.telefone, avg(aps.notaPrestadorServico), ps.cep) from AvaliacaoPrestadorServico aps " +
            "join aps.fkProposta p " +
            "join p.fkPrestadorServico ps " +
            "join ps.fkServico s WHERE s.idTipoServico = ?1 " +
            "GROUP BY ps.nome, ps.email, ps.urlFoto, ps.telefone, ps.cep " +
            "ORDER BY avg(aps.notaPrestadorServico) desc")
    List<FiltroPorAvaliacao> getAvaliacoesPorServico(int idServico);

}
