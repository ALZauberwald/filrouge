package com.lip6.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Stagiaire")
public class Stagiaire extends Personne {
	
	public Stagiaire(String nom, String prenom, String adresse, String tel, String mail) {
		super(nom, prenom, adresse, tel, mail);
	}
	

	public Stagiaire() {
	super();
}


	@ManyToMany(mappedBy = "stagiaires")
	private Set<Session> sessions =  new HashSet<>();
	
//	public long getIdStagiaire() {
//		return idStagiaire;
//	}
//	public void setIdStagiaire(long idStagiaire) {
//		this.idStagiaire = idStagiaire;
//	}
	public Set<Session> getSessions() {
		return sessions;
	}
	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}
	
}
