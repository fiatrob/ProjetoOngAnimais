package dombosco.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dombosco.dominio.Cliente;
import dombosco.repository.ClienteRepository;

@Service
public class ClienteService {

	/*
	 * O propósito de @Autowired é injtetar uma instância da classe declarada como
	 * atributo no escopo da classe trabalhada sem que a segunda saiba como
	 * instanciar a primeira, reduzindo o acoplamento. Pensando em um CRUD, a classe
	 * de serviço deve fornecer as opções de recuperação, inserção, edição e
	 * exclusão.
	 */

	@Autowired
	private ClienteRepository repository;

	public ArrayList<Cliente> findAll() {
		return (ArrayList<Cliente>) repository.findAll();
	}

	public Cliente save(Cliente post) {
		return repository.saveAndFlush(post);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Optional<Cliente> edit(Long id) {
		return repository.findById(id);
	}

}
