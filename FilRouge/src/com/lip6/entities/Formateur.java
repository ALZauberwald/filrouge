package com.lip6.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Formateur")
public class Formateur extends Personne {
	private String dateEmbauche="";
	public Formateur(String nom, String prenom, String adresse, String tel, String mail, String dateEmbauche) {
		super(nom, prenom, adresse, tel, mail);
		this.dateEmbauche = dateEmbauche;
	}
	
	public Formateur(){
		super();
	}

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Session> sessions = new HashSet<>();
	
	public String getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(String dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public Set<Session> getSessions() {
		return sessions;
	}
	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "formateur = " + super.toString() + " dateEmbauche= " + dateEmbauche ;
	}
	
}
