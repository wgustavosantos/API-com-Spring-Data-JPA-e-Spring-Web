package br.com.treinaweb.apispringcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.apispringcrud.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
