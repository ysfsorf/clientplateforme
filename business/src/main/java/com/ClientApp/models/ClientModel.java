package com.ClientApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PreRemove;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@SQLDelete(sql = "UPDATE client_model SET state ='DELETED' WHERE id=?", check = ResultCheckStyle.COUNT)
@Where(clause = "state<>'DELETED'")
public class ClientModel extends UserModel {

	@NotEmpty(message = "social reason must be  not empty")
	@Column(name = "socialReason")
	private String socialReason;

	@NotEmpty(message = "ice must be  not empty")

	@Column(name = "ice")
	private String ice;

	@Enumerated(EnumType.STRING)
	private ClientState state;

	public ClientState getState() {
		return state;
	}

	public void setState(ClientState state) {
		this.state = state;
	}

	public String getIce() {
		return ice;
	}

	public void setIce(String ice) {
		this.ice = ice;
	}

	public String getsocialReason() {
		return socialReason;
	}

	public void setsocialReason(String socialReason) {
		this.socialReason = socialReason;
	}

	@PreRemove
	public void deleteClient() {

		this.state = ClientState.DELETED;
	}

	public ClientModel(String socialReason, String ice, String adresse, String phone, String email) {
		super(adresse, phone, email);
		this.ice = ice;
		this.socialReason = socialReason;

	}

	public ClientModel() {

	}

}
