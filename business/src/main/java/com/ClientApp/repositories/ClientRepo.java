package com.ClientApp.repositories;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.ClientApp.models.ClientModel;


public interface ClientRepo extends JpaRepository<ClientModel, Long>  {

	public ClientModel findBySocialReason(String nom);
	 @Modifying
	   @Transactional
	public void deleteBySocialReason(String nom);
	
	
}
