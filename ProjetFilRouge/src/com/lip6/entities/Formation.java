package com.lip6.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Formation {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFormation;
	
	private String nomFormation;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_objectif")
	private Objectif objectifsFormation;
	private String detailFormation;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_prerequis")
	private Prerequis prerequisFormation;
	
	//constructeur
	public Formation(String nomFormation, Objectif ob, String detailFormation, Prerequis pr) {
		super();
		this.nomFormation = nomFormation;
		this.objectifsFormation = ob;
		this.detailFormation = detailFormation;
		this.prerequisFormation = pr;
	}
	
	public Formation() {  
		
	}

		
	public int getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}

	public String getNomFormation() {
		return nomFormation;
	}

	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}

	public Objectif getObjectifsFormation() {
		return objectifsFormation;
	}

	public void setObjectifsFormation(Objectif objectifsFormation) {
		this.objectifsFormation = objectifsFormation;
	}

	public String getDetailFormation() {
		return detailFormation;
	}

	public void setDetailFormation(String detailFormation) {
		this.detailFormation = detailFormation;
	}

	public Prerequis getPrerequisFormation() {
		return prerequisFormation;
	}

	public void setPrerequisFormation(Prerequis prerequisFormation) {
		this.prerequisFormation = prerequisFormation;
	}

	@Override
	public String toString() {
		return "Formation " + idFormation + "--> nom=" + nomFormation + ", objectifs="
				+ objectifsFormation + ", detail=" + detailFormation + ", prerequis="
				+ prerequisFormation ;
	}
	
	
	
	
	
}
