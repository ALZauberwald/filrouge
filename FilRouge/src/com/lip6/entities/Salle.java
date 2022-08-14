package com.lip6.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Salle {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSalle;
	private String adresse;
	private String nomSalle;
	@OneToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},mappedBy="salle")
	private Set <Session> sessions = new HashSet<>();
	
	public Salle(String adresse, String nomSalle) {
		this.adresse = adresse;
		this.nomSalle = nomSalle;
	}

	public Salle() {
		
	}

	public long getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(long idSalle) {
		this.idSalle = idSalle;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNomSalle() {
		return nomSalle;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}

	public Set<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "Salle [idSalle=" + idSalle + ", adresse=" + adresse
				+ ", nomSalle=" + nomSalle + "]";
	}
	
	
	
}
