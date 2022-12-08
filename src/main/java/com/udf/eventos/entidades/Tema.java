package com.udf.eventos.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tema")
public class Tema implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tema;
	private String nome;
	private String curso;
	private Integer cod_ods;
	private String tipo;
	
	public Tema() {
	}
	
	public Tema(Integer id_tema, String nome, String curso, Integer cod_ods, String tipo) {
		this.id_tema = id_tema;
		this.nome = nome;
		this.curso = curso;
		this.cod_ods = cod_ods;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Integer getCod_ods() {
		return cod_ods;
	}

	public void setCod_ods(Integer cod_ods) {
		this.cod_ods = cod_ods;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getId_tema() {
		return id_tema;
	}

	@Override
	public String toString() {
		return "Tema: " + nome + ", curso: " + curso + ", ODS: " + cod_ods + ", tipo: "
				+ tipo;
	}
}
