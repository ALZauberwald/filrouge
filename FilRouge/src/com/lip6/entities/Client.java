package com.lip6.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
public class Client extends Personne {
	private String numSiret;
	public Client(String nom, String prenom, String adresse, String tel, String mail, String numSiret) {
		super(nom, prenom, adresse, tel, mail);
		this.numSiret = numSiret;
	}
	
	public Client(String nom, String prenom, String adresse, String tel, String mail) {
		super(nom, prenom, adresse, tel, mail);
	}

	public String getNumSiret() {
		return numSiret;
	}
	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}

}
