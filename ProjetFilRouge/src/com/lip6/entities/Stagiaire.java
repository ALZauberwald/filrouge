package com.lip6.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stagiaire extends Personne {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idStagiaire;

	
	public Stagiaire() {
		// TODO Auto-generated constructor stub
	}

	public Stagiaire(String firstName, String lastName, String adr_electron, String adresse) {
		super(firstName, lastName, adr_electron, adresse);
		// TODO Auto-generated constructor stub
	}
	
	public Stagiaire(long idStagiaire) {
		super();
		this.idStagiaire = idStagiaire;
	}

}
