package com.example.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Entreprise implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3788175734710731165L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long code;
	@NotNull
	@Size(min=2,max=30)
	private String nom;
	private String raisonSociale;
	@NotNull
	private String email;
	@OneToMany(mappedBy="entreprise",fetch=FetchType.LAZY)
	private Collection<Taxe> taxes;
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	@JsonIgnore
	public Collection<Taxe> getTaxes() {
		return taxes;
	}
	public void setTaxes(Collection<Taxe> taxes) {
		this.taxes = taxes;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Entreprise() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Entreprise(Long code, String nom, String raisonSociale) {
		super();
		this.code = code;
		this.nom = nom;
		this.raisonSociale = raisonSociale;
	}
	public Entreprise(Long code, String nom, String raisonSociale, String email) {
		super();
		this.code = code;
		this.nom = nom;
		this.raisonSociale = raisonSociale;
		this.email = email;
	}
	
	

}
