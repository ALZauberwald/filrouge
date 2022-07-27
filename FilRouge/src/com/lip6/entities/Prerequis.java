package com.lip6.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Prerequis {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPrerequis;
	private String nomPrerequis;
	
	public Prerequis(String nomPrerequis) {
		super();
		this.nomPrerequis = nomPrerequis;
	}
	public Prerequis() {}
	public int getIdPrerequis() {
		return idPrerequis;
	}
	public void setIdPrerequis(int idPrerequis) {
		this.idPrerequis = idPrerequis;
	}
>>>>>>> f871008343da385c413784f67afd74e497a6b2bb
	public String getNomPrerequis() {
		return nomPrerequis;
	}
	public void setNomPrerequis(String nomPrerequis) {
		this.nomPrerequis = nomPrerequis;
	}
	
}
