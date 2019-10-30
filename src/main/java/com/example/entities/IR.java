package com.example.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("IR")
public class IR extends Taxe{

	public IR() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IR(Long id, String titre, Date dateTaxe, double montant, Entreprise entreprise) {
		super(id, titre, dateTaxe, montant, entreprise);
		// TODO Auto-generated constructor stub
	}

}
