package com.lip6.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component ("classeprerequis")
@Scope ("prototype")
@Entity
public class Prerequis {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPrerequis;
	private String nomPrerequis;
	
	public Prerequis(String nomPrerequis) {
		super();
		this.nomPrerequis = nomPrerequis;
	}
	public Prerequis() {}
	
	public long getIdPrerequis() {
		return idPrerequis;
	}
	public void setIdPrerequis(long idPrerequis) {
		this.idPrerequis = idPrerequis;
	}
	public String getNomPrerequis() {
		return nomPrerequis;
	}
	public void setNomPrerequis(String nomPrerequis) {
		this.nomPrerequis = nomPrerequis;
	}
	@Override
	public String toString() {
		return  idPrerequis + "  |  "+ nomPrerequis ;
	}
	
	
}
