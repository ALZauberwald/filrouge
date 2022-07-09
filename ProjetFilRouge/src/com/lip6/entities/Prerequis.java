package com.lip6.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Prerequis {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPrerequis;
	private String nomPrerequis;
	
	//lien oneto one a upgrader en onetomany ulterieurement
	@OneToOne(mappedBy = "prerequisFormation")
	private Formation formation;
	
	public Prerequis(String nomPrerequis) {
		super();
		this.nomPrerequis = nomPrerequis;
	}
	public Prerequis() {}
	
	
	public String getNomPrerequis() {
		return nomPrerequis;
	}
	public void setNomPrerequis(String nomPrerequis) {
		this.nomPrerequis = nomPrerequis;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	
		

}
