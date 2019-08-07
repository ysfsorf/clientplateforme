package com.ClientApp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
import com.ClientApp.models.ClientModel2;
import com.ClientApp.models.OffreModel;
import com.ClientApp.services.OffreService;
import com.ClientApp.services.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")
@Transactional
public class ClientController {
	@Autowired
	private OffreService offreService;
	@Autowired
	private UserService Userservice;

	@GetMapping(value = { "offers/", "offers" })
	@Produces({ "application/json" })
	public List<OffreModel> getAllOffre() {

		return offreService.getAll();

	}

	@GetMapping(value = { "offers/{id}", "offers" })
	@Produces({ "application/json" })
	public OffreModel getAllOffre(@PathVariable Long id) {

		return offreService.get(id);

	}

	@PostMapping(value = { "offres/", "offres" })
	public ResponseEntity<OffreModel> addoffre(@Valid @RequestBody OffreModel offre) {
		System.out.println("post ");
		offreService.add(offre);
		return ResponseEntity.ok(offre);

	}

	@GetMapping(value = { "/user" })
	public List<ClientModel2> getAllUsers() {
		return Userservice.getAll();

	}

	@GetMapping(value = { "/user/{id}" })
	public ResponseEntity<ClientModel2> getAllUsers(@PathVariable Long id) throws ResourceNotFoundException {
		Optional<ClientModel2> user = Userservice.getClient(id);
		if (!user.isPresent())
			throw new ResourceNotFoundException("non valid  id : " + id);
		return ResponseEntity.ok(user.get());

	}

	@GetMapping(value = { "/user/{id}/offres" })
	public ClientModel2 getUserOffers(@PathVariable Long id) {
		return Userservice.getAlloffers(id);

	}

	@DeleteMapping(value = { "/offres/{idd}" })
	public void deleteUserOffre(@PathVariable Long idd) {

		offreService.deleteOffre(idd);

	}

	@PutMapping(value = { "/{id}" })
	public ResponseEntity<OffreModel> updateClient(@Valid @RequestBody OffreModel offre, @PathVariable Long id)
			throws ResourceNotFoundException {

		if (offreService.exist(id)) {
			offre.setId(id);

			return ResponseEntity.ok(offreService.add(offre));
		} else {
			throw new ResourceNotFoundException("Invalid  id : " + id);
		}
	}

}
