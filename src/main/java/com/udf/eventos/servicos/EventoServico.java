package com.udf.eventos.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udf.eventos.entidades.Evento;
import com.udf.eventos.repositorios.EventoRepositorio;

@Service
public class EventoServico {

	@Autowired
	private EventoRepositorio repositorio;
	
	public List<Evento> findAll(){
		return repositorio.findAll();
	}
	
	public Evento findById(Integer id) {
		Optional<Evento> obj = repositorio.findById(id);
		return obj.get();
	}
	
	public Evento insert(Evento obj) {
		return repositorio.save(obj);
	}
	
	public void delete(Integer id) {
		repositorio.deleteById(id);
	}
	
	public Evento update(Integer id, Evento obj) {
		Evento entidade = repositorio.getReferenceById(id);
		updateData(entidade, obj);
		return repositorio.save(entidade);
	}

	private void updateData(Evento entidade, Evento obj) {
		entidade.setTitulo(obj.getTitulo());
		entidade.setDescricao(obj.getDescricao());
		entidade.setData_inicio(obj.getData_inicio());
		entidade.setData_final(obj.getData_final());
	}
}
