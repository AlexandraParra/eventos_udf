package com.udf.eventos.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "apresentacao")
public class Apresentacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_apresentacao;
	private String nome;
	private String tema;
	@ManyToOne
	@JoinColumn(name="id_evento")
	private Evento evento;
	
	public Apresentacao() {
	}
	
	public Apresentacao(Integer id_apresentacao, String nome, String tema, Evento evento) {
		this.id_apresentacao = id_apresentacao;
		this.nome = nome;
		this.tema = tema;
		this.evento = evento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Integer getId_apresentacao() {
		return id_apresentacao;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	@Override
	public String toString() {
		return "Apresentação: " + nome + ", tema: " + tema;
	}
}
