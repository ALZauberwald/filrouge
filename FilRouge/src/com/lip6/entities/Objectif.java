package com.lip6.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//premiere version de l'objet objectif
@Entity
public class Objectif {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idObjectif;
	private String nomObjectif;
	
	public Objectif(String nomObjectif) {
		super();
		this.nomObjectif = nomObjectif;
	}

	public Objectif() {
		
	}

	public long getIdObjectif() {
		return idObjectif;
	}

	public void setIdObjectif(long idObjectif) {
		this.idObjectif = idObjectif;
	}

	public String getNomObjectif() {
		return nomObjectif;
	}

	public void setNomObjectif(String nomObjectif) {
		this.nomObjectif = nomObjectif;
	}

	@Override
	public String toString() {
		return "Objectif [idObjectif=" + idObjectif + ", nomObjectif=" + nomObjectif + "]";
	}
	
	
}
