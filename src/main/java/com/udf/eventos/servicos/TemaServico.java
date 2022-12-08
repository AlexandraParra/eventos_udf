package com.udf.eventos.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udf.eventos.entidades.Tema;
import com.udf.eventos.repositorios.TemaRepositorio;

@Service
public class TemaServico {

	@Autowired
	private TemaRepositorio repositorio;
	
	public List<Tema> findAll(){
		return repositorio.findAll();
	}
	
	public Tema findById(Integer id) {
		Optional<Tema> obj = repositorio.findById(id);
		return obj.get();
	}
	
	public Tema insert(Tema obj) {
		return repositorio.save(obj);
	}
	
	public void delete(Integer id) {
		repositorio.deleteById(id);
	}
	
	public Tema update(Integer id, Tema obj) {
		Tema entidade = repositorio.getReferenceById(id);
		updateData(entidade, obj);
		return repositorio.save(entidade);
	}

	private void updateData(Tema entidade, Tema obj) {
		entidade.setNome(obj.getNome());
		entidade.setCurso(obj.getCurso());
		entidade.setCod_ods(obj.getCod_ods());
		entidade.setTipo(obj.getTipo());
	}
}
