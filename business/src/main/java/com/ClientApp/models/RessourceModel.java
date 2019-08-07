package com.ClientApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RessourceModel {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String code;
	@Column
	private String debutCarriere;
	@Column
	private String email;
	@Column
	private String firstName;
	@Column
	private String flag;
	@Column
	private String lastName;
	@Column
	private String phone;
	@Column
	private String seniority;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDebutCarriere() {
		return debutCarriere;
	}

	public void setDebutCarriere(String debutCarriere) {
		this.debutCarriere = debutCarriere;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public RessourceModel() {
		super();
	}

	public RessourceModel(String code, String debutCarriere, String email, String firstName, String flag,
			String lastName, String phone, String seniority) {
		super();
		this.code = code;
		this.debutCarriere = debutCarriere;
		this.email = email;
		this.firstName = firstName;
		this.flag = flag;
		this.lastName = lastName;
		this.phone = phone;
		this.seniority = seniority;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSeniority() {
		return seniority;
	}

	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}

}
