package com.example.manotensao.repositorio;

import com.example.manotensao.dto.PropostaCSV;
import com.example.manotensao.dominio.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PropostaRepository extends JpaRepository<Proposta,Integer>{

    @Query("select new com.example.manotensao.dto.PropostaCSV(c.nome, p.qtdDias, p.qtdHoras, p.valorTotal, c.bairro, c.rua) " +
            "from Proposta p " +
            "join p.fkCliente c " +
            "join p.fkPrestadorServico ps " +
            "where ps.idPrestador = ?1 and p.propostaAceita = 1")
    List<PropostaCSV> testeCsv(int idPrestador);

    Proposta getById(int idProposta);



}
