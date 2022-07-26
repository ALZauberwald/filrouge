package com.lip6.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//premiere version de l'objet objectif
@Entity
public class Objectif {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idObjectif;
	private String nomObjectif;
	
	//lien oneto one a upgrader en onetomany ulterieurement
	@OneToOne(mappedBy = "objectifsFormation")
	private Formation formation;
	
	public Objectif(String nomObjectif) {
		super();
		this.nomObjectif = nomObjectif;
	}

	public Objectif() {
		
	}

	public int getIdObjectif() {
		return idObjectif;
	}

	public void setIdObjectif(int idObjectif) {
		this.idObjectif = idObjectif;
	}

	public String getNomObjectif() {
		return nomObjectif;
	}

	public void setNomObjectif(String nomObjectif) {
		this.nomObjectif = nomObjectif;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	
}
