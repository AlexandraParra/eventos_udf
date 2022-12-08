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

import com.udf.eventos.entidades.LocalEndereco;
import com.udf.eventos.servicos.LocalEnderecoServico;

@RestController
@RequestMapping(value = "/locais")
public class LocalEnderecoControler {

	@Autowired
	private LocalEnderecoServico servico;
	
	@GetMapping
	public ResponseEntity<List<LocalEndereco>> findAll(){
		List<LocalEndereco> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LocalEndereco> findById(@PathVariable Integer id) {
		LocalEndereco obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<LocalEndereco> insert(@RequestBody LocalEndereco obj){
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_evento()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<LocalEndereco> update(@PathVariable Integer id, @RequestBody LocalEndereco obj){
		obj = servico.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
