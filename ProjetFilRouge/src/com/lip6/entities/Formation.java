package com.lip6.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Formation {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFormation;	
	private String nomFormation;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "objectifs_par_formation",joinColumns = @JoinColumn(name = "id_formation"), inverseJoinColumns = @JoinColumn(name="id_objectif"))
	private Set<Objectif> objectifsFormation = new HashSet<>();
	
	
	private String detailFormation;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name ="prerequis_par_formation", joinColumns=@JoinColumn(name = "id_formation"),inverseJoinColumns = @JoinColumn(name="id_prerequis"))
	private Set<Prerequis> prerequisFormation= new HashSet<>();
	
	
	//constructeur
	
	
	public Formation() {  
		
	}

		
	public Formation(String nomFormation, String detailFormation) {
		super();
		this.nomFormation = nomFormation;
		this.detailFormation = detailFormation;
		
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



	public Set<Objectif> getObjectifsFormation() {
		return objectifsFormation;
	}


	public void setObjectifsFormation(Set<Objectif> objectifsFormation) {
		this.objectifsFormation = objectifsFormation;
	}


	public String getDetailFormation() {
		return detailFormation;
	}

	public void setDetailFormation(String detailFormation) {
		this.detailFormation = detailFormation;
	}

	

	public Set<Prerequis> getPrerequisFormation() {
		return prerequisFormation;
	}


	public void setPrerequisFormation(Set<Prerequis> prerequisFormation) {
		this.prerequisFormation = prerequisFormation;
	}


	@Override
	public String toString() {
		return "Formation " + idFormation + "--> nom=" + nomFormation + ", objectifs="
				+ objectifsFormation + ", detail=" + detailFormation + ", prerequis="
				+ prerequisFormation ;
	}
	
	
	
	
	
}
