package com.example.manotensao.repositorio;

import com.example.manotensao.dominio.AvaliacaoCliente;
import com.example.manotensao.dto.FiltroPorAvaliacao;
import com.example.manotensao.dominio.AvaliacaoPrestadorServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AvaliacaoPrestadorServicoRepository extends JpaRepository<AvaliacaoPrestadorServico, Integer>{
    @Query("select new com.example.manotensao.dto.FiltroPorAvaliacao(ps.nome, ps.email, ps.urlFoto, ps.telefone, avg(aps.notaPrestadorServico), ps.cep, ps.bairro, ps.rua, ps.numero) from AvaliacaoPrestadorServico aps " +
            "join aps.fkProposta p " +
            "join p.fkPrestadorServico ps " +
            "GROUP BY ps.nome, ps.email, ps.urlFoto, ps.telefone, ps.cep " +
            "ORDER BY avg(aps.notaPrestadorServico) desc")
    List<FiltroPorAvaliacao> getAvaliacoes();

    @Query("select new com.example.manotensao.dto.FiltroPorAvaliacao(ps.nome, ps.email, ps.urlFoto, ps.telefone, avg(aps.notaPrestadorServico), ps.cep, ps.bairro, ps.rua, ps.numero) from AvaliacaoPrestadorServico aps " +
            "join aps.fkProposta p " +
            "join p.fkPrestadorServico ps " +
            "join ps.fkServico s WHERE s.idTipoServico = ?1  or s.idTipoServico = ?2 or s.idTipoServico = ?3 or s.idTipoServico = ?4 " +
            "GROUP BY ps.nome, ps.email, ps.urlFoto, ps.telefone, ps.cep " +
            "ORDER BY avg(aps.notaPrestadorServico) desc")
    List<FiltroPorAvaliacao> getAvaliacoesPorServico(int idServico, int segundaVariacao, int terceiraVariacao, int quartaVariacao);


    AvaliacaoPrestadorServico getById(int idAvaliacaoPrestadorServico);
}
