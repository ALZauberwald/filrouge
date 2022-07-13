package com.lip6.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Salle {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSalle;
	private boolean installationFinie=false;
	private String adresse;
	private String nomSalle;
	
	public Salle(String adresse, String nomSalle) {
		this.adresse = adresse;
		this.nomSalle = nomSalle;
	}

	public Salle() {
		
	}

	public int getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(int idSalle) {
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
	
	
	
	
}
