package com.lip6.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Client extends Personne {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idClient;
	private String numSiret;
	
	
	
	public Client() {
		// TODO Auto-generated constructor stub	
		
	}

	public Client(String firstName, String lastName, String adr_electron, String adresse) {
		super(firstName, lastName, adr_electron, adresse);
		// TODO Auto-generated constructor stub
	}

	public Client(long idClient, String numSiret) {
		super();
		this.idClient = idClient;
		this.numSiret = numSiret;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", numSiret=" + numSiret + "]";
	}
	
	
	

}
