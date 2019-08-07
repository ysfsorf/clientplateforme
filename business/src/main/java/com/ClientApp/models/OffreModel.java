package com.ClientApp.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class OffreModel implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	@NotEmpty(message = "code reason must be  not empty")
	private String code;
	@Column
	@NotEmpty(message = "description reason must be  not empty")
	private String description;
	@Column
	@NotEmpty(message = "duree reason must be  not empty")
	private String duree;
	@Column
	@NotEmpty(message = "etat reason must be  not empty")
	private String etat;
	@Column
	@NotEmpty(message = "lieu reason must be  not empty")
	private String lieu;
	@Column
	@NotEmpty(message = "limitDate reason must be  not empty")
	private String limitDate;
	@Column
	@NotEmpty(message = "name reason must be  not empty")
	private String name;
	@Column
	@NotEmpty(message = "postedDate reason must be  not empty")
	private String postedDate;
	@Column
	@NotEmpty(message = "senior reason must be  not empty")
	private String senior;
	@Column
	@NotEmpty(message = "source reason must be  not empty")
	private String source;
	@Column
	@NotEmpty(message = "type reason must be  not empty")
	private String type;

	@ManyToOne
	@JoinColumn(name = "client_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "offres" })
	// @JsonManagedReference

	private ClientModel2 client;

	public OffreModel(String code, String description, String duree, String etat, String lieu, String limitDate,
			String name, String postedDate, String senior, String source, String type, ClientModel2 client) {
		super();
		this.code = code;
		this.description = description;
		this.duree = duree;
		this.etat = etat;
		this.lieu = lieu;
		this.limitDate = limitDate;
		this.name = name;
		this.postedDate = postedDate;
		this.senior = senior;
		this.source = source;
		this.type = type;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}

	public String getSenior() {
		return senior;
	}

	public void setSenior(String senior) {
		this.senior = senior;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ClientModel2 getClient() {
		return client;
	}

	public void setClient(ClientModel2 client) {
		this.client = client;
	}

	public OffreModel() {
		super();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (!(o instanceof OffreModel))
			return false;

		return id != null && id.equals(((OffreModel) o).getId());
	}

	@Override
	public int hashCode() {
		return 31;
	}

}
