package com.example.manotensao.repositorio;

import com.example.manotensao.dominio.AvaliacaoCliente;
import com.example.manotensao.dominio.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoClienteRepository extends JpaRepository<AvaliacaoCliente, Integer>{
    AvaliacaoCliente getById(int idAvaliacaoCliente);

}
