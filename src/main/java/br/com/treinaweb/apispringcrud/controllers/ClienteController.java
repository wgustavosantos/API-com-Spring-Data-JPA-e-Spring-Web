package br.com.treinaweb.apispringcrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.apispringcrud.entities.Cliente;
import br.com.treinaweb.apispringcrud.repositories.ClienteRepository;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente cadastrar(Cliente cliente) {
		
		return null;
	}

}
