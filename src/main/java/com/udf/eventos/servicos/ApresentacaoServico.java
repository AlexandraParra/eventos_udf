package com.udf.eventos.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udf.eventos.entidades.Apresentacao;
import com.udf.eventos.repositorios.ApresentacaoRepositorio;

@Service
public class ApresentacaoServico {

	@Autowired
	private ApresentacaoRepositorio repositorio;
	
	public List<Apresentacao> findAll(){
		return repositorio.findAll();
	}
	
	public Apresentacao findById(Integer id) {
		Optional<Apresentacao> obj = repositorio.findById(id);
		return obj.get();
	}
	
	public Apresentacao insert(Apresentacao obj) {
		return repositorio.save(obj);
	}
	
	public void delete(Integer id) {
		repositorio.deleteById(id);
	}
	
	public Apresentacao update(Integer id, Apresentacao obj) {
		Apresentacao entidade = repositorio.getReferenceById(id);
		updateData(entidade, obj);
		return repositorio.save(entidade);
	}

	private void updateData(Apresentacao entidade, Apresentacao obj) {
		entidade.setNome(obj.getNome());
		entidade.setTema(obj.getTema());
	}
}
