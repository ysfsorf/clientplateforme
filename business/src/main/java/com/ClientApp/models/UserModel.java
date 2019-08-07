package com.ClientApp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public abstract class UserModel {
	@Id
	@GeneratedValue
	@Column(name = "id")

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message = "email not empty")
	@Email(message = "must be an email")
	@Column(name = "email")
	private String email;

	@NotEmpty(message = "phone must be  not empty")
	@Column(name = "phone")
	private String phone;

	@NotEmpty(message = "adress must be  not empty")

	@Column(name = "adresse")
	private String adresse;

	@CreationTimestamp
	@Column(name = "createdAt")
	private Date createdAt;

	@UpdateTimestamp
	@Column(name = "UpdateAt")
	private Date UpdateAt;

	public UserModel(String adresse, String phone, String email) {
		super();
		this.adresse = adresse;
		this.phone = phone;
		this.email = email;

	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return UpdateAt;
	}

	public void setUpdateAt(Date updateAt) {
		UpdateAt = updateAt;
	}

	public UserModel() {
		super();
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
