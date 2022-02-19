package com.blogPessoal.CRUDBlogPessoal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogPessoal.CRUDBlogPessoal.Model.ModelPostagem;
import com.blogPessoal.CRUDBlogPessoal.Repository.RepositoryPostagem;



@RestController
@RequestMapping("/postagem")
@CrossOrigin(origins = "*", allowedHeaders = "*")   // Ele abre qualquer requisição que for solicitada

public class ControllerPostagem {

@Autowired
private RepositoryPostagem repository;

@GetMapping
public ResponseEntity<List<ModelPostagem>> GetAll(){
	return ResponseEntity.ok(repository.findAll());       // Perguntar
}

@GetMapping("/{id}")
public ResponseEntity<ModelPostagem> GetById(@PathVariable long id){
	return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
}

@GetMapping("/titulo/{titulo}")
public ResponseEntity<List<ModelPostagem>> GetByTititulo(@PathVariable String titulo) {
    return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
}

@PostMapping
public ResponseEntity<ModelPostagem> post(@RequestBody ModelPostagem postagem) {
    return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));

}

@PutMapping
public ResponseEntity<ModelPostagem> putBody(@RequestBody ModelPostagem postagem) {

    return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));

}

@DeleteMapping("/{id}")
public void delete(@PathVariable long id) {

    repository.deleteById(id);

}

}




