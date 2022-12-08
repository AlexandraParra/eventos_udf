package com.udf.eventos.controladores;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.udf.eventos.entidades.Apresentacao;
import com.udf.eventos.servicos.ApresentacaoServico;

@RestController
@RequestMapping(value = "/apresentacoes")
public class ApresentacaoControler {

	@Autowired
	private ApresentacaoServico servico;
	
	@GetMapping
	public ResponseEntity<List<Apresentacao>> findAll(){
		List<Apresentacao> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Apresentacao> findById(@PathVariable Integer id) {
		Apresentacao obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Apresentacao> insert(@RequestBody Apresentacao obj){
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_apresentacao()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Apresentacao> update(@PathVariable Integer id, @RequestBody Apresentacao obj){
		obj = servico.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
