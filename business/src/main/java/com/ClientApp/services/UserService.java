package com.ClientApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ClientApp.models.ClientModel2;
import com.ClientApp.repositories.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	public List<ClientModel2> getAll() {
		return userRepo.findAll();
	}

	public ClientModel2 getAlloffers(Long id) {

		return userRepo.getById(id);

	}

	public Optional<ClientModel2> getClient(Long id) {

		return userRepo.findById(id);

	}

}
