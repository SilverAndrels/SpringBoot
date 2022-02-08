package com.example.demo.controller;

import java.util.Optional;

import com.example.demo.model.entities.Cliente;
import com.example.demo.model.repositorie.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nome")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public Iterable<Cliente> obterClientes() {
		return clienteRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Cliente> obterClientePorId(@PathVariable int id) {
		return clienteRepository.findById(id);
	}
	
	@PostMapping
	@RequestMapping("/post")
	public Cliente inserirCliente(@RequestParam String nome) {
		Cliente cliente = new Cliente(nome);
		clienteRepository.save(cliente);
		return cliente;
	}

	@DeleteMapping("/del/{id}")
	public void deleteCliente(Cliente cliente, Cliente id) {
		clienteRepository.delete(cliente);
	}

	@PutMapping("/atualizar/{id}")
	public Cliente atualizaCliente(Cliente cliente, Cliente id) {
		return clienteRepository.save(cliente);
	}
}
