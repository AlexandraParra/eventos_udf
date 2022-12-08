package com.udf.eventos.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udf.eventos.entidades.LocalEndereco;
import com.udf.eventos.repositorios.LocalEnderecoRepositorio;

@Service
public class LocalEnderecoServico {

	@Autowired
	private LocalEnderecoRepositorio repositorio;
	
	public List<LocalEndereco> findAll(){
		return repositorio.findAll();
	}
	
	public LocalEndereco findById(Integer id) {
		Optional<LocalEndereco> obj = repositorio.findById(id);
		return obj.get();
	}
	
	public LocalEndereco insert(LocalEndereco obj) {
		return repositorio.save(obj);
	}
	
	public void delete(Integer id) {
		repositorio.deleteById(id);
	}
	
	public LocalEndereco update(Integer id, LocalEndereco obj) {
		LocalEndereco entidade = repositorio.getReferenceById(id);
		updateData(entidade, obj);
		return repositorio.save(entidade);
	}

	private void updateData(LocalEndereco entidade, LocalEndereco obj) {
		entidade.setEstado(obj.getEstado());
		entidade.setCidade(obj.getCidade());
		entidade.setMunicipio(obj.getMunicipio());
		entidade.setRua(obj.getRua());
	}
}
