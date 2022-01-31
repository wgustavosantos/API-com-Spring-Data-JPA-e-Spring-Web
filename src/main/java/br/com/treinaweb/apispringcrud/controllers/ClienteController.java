package br.com.treinaweb.apispringcrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.apispringcrud.entities.Cliente;
import br.com.treinaweb.apispringcrud.repositories.ClienteRepository;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping
	public Cliente cadastrar(@RequestBody Cliente cliente) {
		
		return clienteRepository.save(cliente);
	}

}
