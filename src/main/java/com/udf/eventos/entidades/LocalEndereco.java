package com.udf.eventos.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "localEndereco")
public class LocalEndereco implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id_evento;
	private String estado;
	private String cidade;
	private String municipio;
	private String rua;
	
	public LocalEndereco() {
	}

	public LocalEndereco(Integer id_evento, String estado, String cidade, String municipio, String rua) {
		this.estado = estado;
		this.cidade = cidade;
		this.municipio = municipio;
		this.rua = rua;
		this.id_evento = id_evento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getId_evento() {
		return id_evento;
	}

	public void setId_evento(Integer id_evento) {
		this.id_evento = id_evento;
	}

	@Override
	public String toString() {
		return "Local endereço\nEstado: " + estado + ", cidade: " + cidade + ", municipio: " + municipio + ", rua: " + rua
				+ ", evento: " + id_evento;
	}
	
}
