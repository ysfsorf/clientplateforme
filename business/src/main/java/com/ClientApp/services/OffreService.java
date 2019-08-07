package com.ClientApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ClientApp.models.OffreModel;
import com.ClientApp.repositories.OffreRepo;

@Service
public class OffreService {
	@Autowired
	private OffreRepo offreRepo;

	public List<OffreModel> getAll() {
		return offreRepo.findAll();
	}

	public OffreModel add(OffreModel offre) {

		return offreRepo.save(offre);
	}

	public OffreModel get(Long id) {

		return offreRepo.getOne(id);

	}

	public Boolean exist(Long id) {
		if (offreRepo.existsById(id)) {
			return true;
		}
		return false;
	}

	public void delete(Long id) {
		offreRepo.deleteById(id);
	}

	public void deleteOffre(Long idd) {
		// TODO Auto-generated method stub
		offreRepo.deleteById(idd);
	}

}
