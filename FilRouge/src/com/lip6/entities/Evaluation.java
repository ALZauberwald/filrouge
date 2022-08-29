package com.lip6.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Evaluation {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEvaluation;
	
	private String nomEvaluation;
	
//	@ManyToOne
//	@JoinColumn(name="id_stagiaire")
//	private Stagiaire stagiaire;
	
	
	public Evaluation(int idEvaluation, String nomEvaluation) {
		super();
		this.idEvaluation = idEvaluation;
		this.nomEvaluation = nomEvaluation;
	}
	
	public Evaluation() {
		
	}
	public Evaluation(String nomEvaluation) {
		super();
		this.nomEvaluation = nomEvaluation;
	}
	public int getIdEvaluation() {
		return idEvaluation;
	}
	
	public void setIdEvaluation(int idEvaluation) {
		this.idEvaluation = idEvaluation;
	}
	public String getNomEvaluation() {
		return nomEvaluation;
	}
	public void setNomEvaluation(String nomEvaluation) {
		this.nomEvaluation = nomEvaluation;
	}
//	public Stagiaire getStagiaire() {
//		return stagiaire;
//	}
//	public void setStagiaire(Stagiaire stagiaire) {
//		this.stagiaire = stagiaire;
//	}

	@Override
	public String toString() {
		return "Evaluation [idEvaluation=" + idEvaluation + ", nomEvaluation=" + nomEvaluation + "]";
	}
	
	

}
