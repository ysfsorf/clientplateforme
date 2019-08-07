package com.ClientApp.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;

@Entity
@NamedEntityGraph(name = "clientoffers", attributeNodes = @NamedAttributeNode("offres"))

public class ClientModel2 extends UserModel implements Serializable {

	@Column(name = "socialReason")
	private String socialReason;

	@Column(name = "ice")
	private String ice;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	// @JsonBackReference

	private List<OffreModel> offres = new ArrayList<>();

	public void addComment(OffreModel offre) {
		offres.add(offre);
		offre.setClient(this);
	}

	public void removeComment(OffreModel offre) {
		offres.remove(offre);
		offre.setClient(null);
	}

	public String getIce() {
		return ice;
	}

	public String getSocialReason() {
		return socialReason;
	}

	public void setSocialReason(String socialReason) {
		this.socialReason = socialReason;
	}

	public List<OffreModel> getOffres() {
		return offres;
	}

	public void setOffres(List<OffreModel> offres) {
		this.offres = offres;
	}

	public void setIce(String ice) {
		this.ice = ice;
	}

	public ClientModel2(String socialReason, String ice, String adresse, String phone, String email) {
		super(adresse, phone, email);
		this.ice = ice;
		this.socialReason = socialReason;

	}

	public ClientModel2() {

	}

}
