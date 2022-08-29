package com.lip6.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Stagiaire")
public class Stagiaire extends Personne {
	
	public Stagiaire(String nom, String prenom, String adresse, String tel, String mail) {
		super(nom, prenom, adresse, tel, mail);
	}
	

	public Stagiaire() {
	super();
}


	@ManyToMany(cascade = {CascadeType.PERSIST,
							CascadeType.DETACH,
							CascadeType.MERGE,
							CascadeType.REFRESH
			})
	@JoinTable(name ="Stagiaires_par_Sessions", joinColumns=@JoinColumn(name = "id_Stagiaire"),inverseJoinColumns = @JoinColumn(name="id_Sessions"))
	private Set<Session> sessions =  new HashSet<>();
	
	public Set<Session> getSessions() {
		return sessions;
	}
	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}
	@Override
	public String toString() {
		return getId() + "  |  " + getNom();
	}
}
