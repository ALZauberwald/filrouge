package com.lip6.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Formateur extends Personne {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFormateur;
	private final Date date_emb;
	private String CV;
	

	
	
	@Override
	public String toString() {
		return "Formateur [idFormateur=" + idFormateur + ", date_emb=" + date_emb + ", CV=" + CV + "]";
	}

	public Formateur(long idFormateur, Date date_emb, String cV) {
		super();
		this.idFormateur = idFormateur;
		this.date_emb = date_emb;
		CV = cV;
	}

	public long getIdFormateur() {
		return idFormateur;
	}

	public void setIdFormateur(long idFormateur) {
		this.idFormateur = idFormateur;
	}

	public String getCV() {
		return CV;
	}

	public void setCV(String cV) {
		CV = cV;
	}

	public Date getDate_emb() {
		return date_emb;
	}

	public Formateur() {
		// TODO Auto-generated constructor stub
	}

	public Formateur(String firstName, String lastName, String adr_electron, String adresse) {
		super(firstName, lastName, adr_electron, adresse);
		// TODO Auto-generated constructor stub
	}

}
