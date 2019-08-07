package com.ClientApp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ClientApp.exception.ResourceNotFoundException;
import com.ClientApp.models.ClientModel;
import com.ClientApp.models.ClientState;
import com.ClientApp.services.ClientService;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/clients")

@RestController
public class Controller {

	@Autowired
	private ClientService service;

	@GetMapping(value = { "/", "" })
	public List<ClientModel> getAllClient() {
		return service.getAll();

	}

	@PostMapping(value = { "/", "" })
	public ResponseEntity<ClientModel> addClient(@Valid @RequestBody ClientModel client) {
		client.setState(ClientState.ACTIVE);
		service.add(client);
		return ResponseEntity.ok(client);

	}

	@PutMapping(value = { "/{Id}" })
	public ResponseEntity<ClientModel> updateClient(@Valid @RequestBody ClientModel client, @PathVariable Long Id)
			throws ResourceNotFoundException {

		if (service.getbyId(Id)) {
			client.setId(Id);
			client.setState(ClientState.ACTIVE);
			return ResponseEntity.ok(service.add(client));
		} else {
			throw new ResourceNotFoundException("Invalid  id : " + Id);
		}
	}

	@GetMapping("/{nom}")
	public ResponseEntity<ClientModel> findByName(@PathVariable String nom) {
		ClientModel client = service.get(nom);

		if (client == null) {
			// throw new ResourceNotFoundException("Invalid name : " + nom);
			// ResponseEntity.badRequest().build();

			return null;

		} else {

			return ResponseEntity.ok(client);
		}
	}

	@GetMapping("/client/{id}")
	public Optional<ClientModel> findByid(@PathVariable Long id) throws ResourceNotFoundException {
		Optional<ClientModel> studentOptional = service.findById(id);
		if (!studentOptional.isPresent()) {

			throw new ResourceNotFoundException("Invalid  name : " + id);

		} else {

			return service.findById(id);
		}

	}

	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable Long id) {
		service.delete(id);

	}

}
