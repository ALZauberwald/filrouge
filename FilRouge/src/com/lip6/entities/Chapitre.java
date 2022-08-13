package com.lip6.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Chapitre {
	@Id@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long idChapitre;
	
	private String nomChapitre;
	
	private int dureeChapitre;
	
	private String detailChapitre;
	
	@ManyToOne
	private Formation formation;

	public Chapitre(String nomChapitre, int dureeChapitre, String detailChapitre) {
		super();
		this.nomChapitre = nomChapitre;
		this.dureeChapitre = dureeChapitre;
		this.detailChapitre = detailChapitre;
	}
	public Chapitre() {}
	
	public long getIdChapitre() {
		return idChapitre;
	}

	public void setIdChapitre(long idChapitre) {
		this.idChapitre = idChapitre;
	}

	public String getNomChapitre() {
		return nomChapitre;
	}

	public void setNomChapitre(String nomChapitre) {
		this.nomChapitre = nomChapitre;
	}

	public int getDureeChapitre() {
		return dureeChapitre;
	}

	public void setDureeChapitre(int dureeChapitre) {
		this.dureeChapitre = dureeChapitre;
	}

	public String getDetailChapitre() {
		return detailChapitre;
	}

	public void setDetailChapitre(String detailChapitre) {
		this.detailChapitre = detailChapitre;
	}


	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detailChapitre == null) ? 0 : detailChapitre.hashCode());
		result = prime * result + dureeChapitre;
		result = prime * result + ((formation == null) ? 0 : formation.hashCode());
		result = prime * result + ((nomChapitre == null) ? 0 : nomChapitre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chapitre other = (Chapitre) obj;
		if (detailChapitre == null) {
			if (other.detailChapitre != null)
				return false;
		} else if (!detailChapitre.equals(other.detailChapitre))
			return false;
		if (dureeChapitre != other.dureeChapitre)
			return false;
		if (formation == null) {
			if (other.formation != null)
				return false;
		} else if (!formation.equals(other.formation))
			return false;
		if (nomChapitre == null) {
			if (other.nomChapitre != null)
				return false;
		} else if (!nomChapitre.equals(other.nomChapitre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Chapitre -->  nomChapitre=" + nomChapitre + ", idChapitre=" + idChapitre + ", dureeChapitre="
				+ dureeChapitre + ", detailChapitre=" + detailChapitre + ", formation=" + formation ;
	}



}
