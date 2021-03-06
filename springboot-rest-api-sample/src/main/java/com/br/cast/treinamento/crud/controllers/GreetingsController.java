package com.br.cast.treinamento.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.cast.treinamento.crud.model.Usuario;
import com.br.cast.treinamento.crud.repository.UsuarioRepository;

@RestController
public class GreetingsController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(value="/usuario/insert/{nome}/{idade}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String insert(@PathVariable String nome, @PathVariable int idade) {
		
		Usuario usuario = new Usuario();
		
		usuario.setNome(nome);
		usuario.setIdade(idade);
		
		usuarioRepository.save(usuario);
		
		return usuario.toString() + " Salvo!"; 
	}
	
	@RequestMapping(value="/usuario/delet/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String delet(@PathVariable Long id) {
		
		Usuario usuario = new Usuario();

		usuario.setId(id);
		
		usuarioRepository.delete(usuario);
		
		return usuario.toString() + " Deletado!"; 
	}
	
	
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	@RequestMapping(value="/usuarios", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> list = usuarioRepository.findAll();
		
		return ResponseEntity.ok().body(list);
	}
}