package com.example.manotensao.repositorio;

import com.example.manotensao.dominio.ChatPrestador;
import com.example.manotensao.dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatPrestadorRepository extends JpaRepository<ChatPrestador,Integer> {
}
