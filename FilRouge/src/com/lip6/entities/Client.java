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

@Entity
@Table(name = "Client")
public class Client extends Personne {
	private String numSiret;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.REFRESH
	})
	@JoinTable(name ="Clients_par_Sessions", joinColumns=@JoinColumn(name = "id_Client"),inverseJoinColumns = @JoinColumn(name="id_Session"))
	private Set<Session> sessions =  new HashSet<>();
	
	public Client(String nom, String prenom, String adresse, String tel, String mail, String numSiret) {
		super(nom, prenom, adresse, tel, mail);
		this.numSiret = numSiret;
	}
	
	public Client(String nom, String prenom, String adresse, String tel, String mail) {
		super(nom, prenom, adresse, tel, mail);
	}

	public Client() {
		
	}

	public String getNumSiret() {
		return numSiret;
	}
	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}
	public Set<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getId() + "  |  " + getNom();
	}

}
