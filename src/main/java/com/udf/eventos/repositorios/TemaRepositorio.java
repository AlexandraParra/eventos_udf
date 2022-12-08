package com.udf.eventos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udf.eventos.entidades.Tema;

public interface TemaRepositorio extends JpaRepository<Tema, Integer>{

}
