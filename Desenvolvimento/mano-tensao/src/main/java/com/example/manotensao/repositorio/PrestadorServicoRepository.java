package com.example.manotensao.repositorio;

import com.example.manotensao.dto.CartaApresentacao;
import com.example.manotensao.dominio.PrestadorServico;
import com.example.manotensao.dto.FiltroPorAvaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PrestadorServicoRepository extends JpaRepository<PrestadorServico, Integer>{
    @Query("select new com.example.manotensao.dto.FiltroPorAvaliacao(ps.nome, ps.email, ps.urlFoto, ps.telefone, avg(aps.notaPrestadorServico), ps.cep, ps.bairro, ps.rua, ps.numero) from AvaliacaoPrestadorServico aps " +
            "join aps.fkProposta p " +
            "join p.fkPrestadorServico ps " +
            "join ps.fkServico s WHERE s.idTipoServico = ?1 or s.idTipoServico = ?2 or s.idTipoServico = ?3 " +
            "or s.idTipoServico = ?4 GROUP BY ps.nome, ps.email, ps.urlFoto, ps.telefone, ps.cep, ps.bairro, ps.rua, ps.numero")
    List<FiltroPorAvaliacao> getPrestadorPorServico(int idServico, int segundaVariacao,
                                                    int terceiraVariacao, int quartaVariacao);

    @Query("select new com.example.manotensao.dto.CartaApresentacao(ps.nome, ps.email, ps.telefone, ps.cartaApresentacao) " +
            "from PrestadorServico ps " +
            "where ps.idPrestador = ?1")
    CartaApresentacao getCartaApresentacao(int idPrestador);

    @Query("select count(id_proposta) from Proposta p " +
            "join p.fkPrestadorServico ps " +
            "where ps.idPrestador = ?1 and Month(data_proposta) = Month(GETDATE())")
    Integer getPropostasNoUltimoMes(int idPrestador);
}
