
package com.ClientApp.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ClientApp.models.ClientModel2;

public interface UserRepo extends JpaRepository<ClientModel2, Long> {

	@EntityGraph(value = "clientoffers", type = EntityGraphType.LOAD)
	ClientModel2 getById(Long id);

	@Query("SELECT p FROM ClientModel2 p JOIN FETCH p.offres WHERE p.id = (:id)")
	public ClientModel2 findByIdAndFetchOffresEagerly(@Param("id") Long id);

	public ClientModel2 findBySocialReason(String nom);

	@Modifying
	@Transactional
	public void deleteByOffresId(Long id);
}
