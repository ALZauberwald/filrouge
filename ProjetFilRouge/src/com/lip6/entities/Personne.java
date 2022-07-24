package com.lip6.entities;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


abstract public class Personne {

	private String firstName;
	private String lastName;
	private String adr_electron;
	private String adresse;
	

	public Personne(){
	}


	
	public Personne(String firstName, String lastName, String adr_electron, String adresse) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.adr_electron = adr_electron;
		this.adresse = adresse;
	}



	@Override
	public String toString() {
		return "Personne [firstName=" + firstName + ", lastName=" + lastName + ", adr_electron=" + adr_electron
				+ ", adresse=" + adresse + "]";
	}



	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAdr_electron() {
		return adr_electron;
	}


	public void setAdr_electron(String adr_electron) {
		this.adr_electron = adr_electron;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	

	


}