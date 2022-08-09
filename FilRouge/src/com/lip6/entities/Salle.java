package com.lip6.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Salle {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSalle;
	@Column(columnDefinition = "BOOLEAN")
	private boolean installationFinie=false;
	private String adresse;
	private String nomSalle;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="salle")
	private Set <Session> sessions = new HashSet<Session>();
	
	public Salle(String adresse, String nomSalle) {
		this.adresse = adresse;
		this.nomSalle = nomSalle;
		this.installationFinie=false;
	}

	public Salle() {
		
	}

	public long getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(long idSalle) {
		this.idSalle = idSalle;
	}

	public boolean getInstallationFinie() {
		return installationFinie;
	}

	public void setInstallationFinie(boolean installationFinie) {
		this.installationFinie = installationFinie;
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

	public Set <Session> getSessions() {
		return sessions;
	}

	public void setSessions(HashSet <Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "Salle [idSalle=" + idSalle + ", installationFinie=" + installationFinie + ", adresse=" + adresse
				+ ", nomSalle=" + nomSalle + "]";
	}
	
	
	
}
