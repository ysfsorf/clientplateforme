package com.ClientApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ClientApp.models.OffreModel;

public interface OffreRepo extends JpaRepository<OffreModel, Long> {

}
