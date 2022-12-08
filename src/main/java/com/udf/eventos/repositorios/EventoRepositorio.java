package com.udf.eventos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udf.eventos.entidades.Evento;

public interface EventoRepositorio extends JpaRepository<Evento, Integer>{

}
