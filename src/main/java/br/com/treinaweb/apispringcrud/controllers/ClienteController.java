package br.com.treinaweb.apispringcrud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

import br.com.treinaweb.apispringcrud.entities.Cliente;
import br.com.treinaweb.apispringcrud.repositories.ClienteRepository;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cliente cadastrar(@RequestBody Cliente cliente) {
		
		return clienteRepository.save(cliente);
	}
	
	@GetMapping 
	public List<Cliente> listar() {
		
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Cliente buscarPorId(@PathVariable Long id) {
		var clienteOptional = clienteRepository.findById(id);
		
		if(clienteOptional.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return clienteOptional.get();	
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (code = HttpStatus.NO_CONTENT) /* operação foi realizada com sucesso, porém não tem nada a ser exibido */
	public void deletarCliente(@PathVariable Long id) {
		
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		
		if(clienteOptional.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		clienteRepository.delete(clienteOptional.get());
		
	}

}
