package com.udf.eventos.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "evento")
public class Evento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_evento;
	private String titulo;
	private String descricao;
	private Date data_inicio;
	private Date data_final;
	@OneToMany(mappedBy = "evento")
	private List<Apresentacao> apresentacao = new ArrayList<>();
	@ManyToMany
	@JoinTable(name = "temaEvento", joinColumns = @JoinColumn(name = "id_evento"), inverseJoinColumns = @JoinColumn(name = "id_tema"))
	List<Tema> Tema = new ArrayList<>();
	
	
	public Evento() {
	}
	
	public Evento(Integer id_evento, String titulo, String descricao, Date data_inicio, Date data_final) {
		this.id_evento = id_evento;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data_inicio = data_inicio;
		this.data_final = data_final;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_final() {
		return data_final;
	}

	public void setData_final(Date data_final) {
		this.data_final = data_final;
	}

	public Integer getId_evento() {
		return id_evento;
	}

	/*public List<Apresentacao> getApresentacoes() {
		return apresentacoes;
	}

	public List<Tema> getTemas() {
		return temas;
	}*/

	@Override
	public String toString() {
		return "Evento: " + titulo + "\nDescrição: " + descricao + ", data início: " + data_inicio
				+ ", data final: " + data_final;
	}
}
