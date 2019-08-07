package com.ClientApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ClientApp.models.*;
import com.ClientApp.repositories.*;
import java.util.Optional;


@Service
public class ClientService {
	
	@Autowired
	private ClientRepo clientRepo;
	
	
	public List<ClientModel> getAll() {
		return clientRepo.findAll();
	}
	public ClientModel get(String nom) {
	
		return clientRepo.findBySocialReason(nom);

	}
	public Boolean getbyId(Long id) {
		if(clientRepo.existsById(id)) {
			return true;
		}
			return false;
	}

	public ClientModel add(ClientModel client) {
		return clientRepo.save(client);
	}

	public void delete(Long id) {
		clientRepo.deleteById(id);
	}
	
	public Optional<ClientModel> findById(Long id) {
        return clientRepo.findById(id);
    }
	
	
	

}
