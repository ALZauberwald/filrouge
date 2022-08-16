package com.lip6.services;

import java.util.Set;

import com.lip6.daos.DAOClient;
import com.lip6.entities.Client;

public class ClientService {
	public void addClient(long idSession,String nomClient,String prenomClient,String adresse,String tel,String mail,String numSiret){
		DAOClient daos = new DAOClient();
		daos.addClient(idSession,nomClient,prenomClient,adresse,tel,mail,numSiret);
		
	}


	public Client searchClient(Long idClient) {
		DAOClient daos = new DAOClient();
		return daos.searchClient(idClient);
	}


	public void removeClient(long idClient) {
		DAOClient daos = new DAOClient();
		daos.removeClient(idClient);
	}
	
	public void updateClient(long idClient , String champAModif , String modif) {
		DAOClient daos = new DAOClient();
		
		Client cl = daos.searchClient(idClient);
		
		if(champAModif.contentEquals("nom")) {
			cl.setNom(modif);
		}
		else if(champAModif.contentEquals("prenom")) {
			cl.setPrenom(modif);
		}
		else if(champAModif.contentEquals("adresse")) {
			cl.setAdresse(modif);
		}
		else if(champAModif.contentEquals("tel")) {
			cl.setTel(modif);
		}
		else if(champAModif.contentEquals("mail")) {
			cl.setMail(modif);
		}
		else if(champAModif.contentEquals("siret")) {
			cl.setNumSiret(modif);
		}
		daos.updateClient(cl);
	}
	public Set<Client> recupClient(){ 
		DAOClient daos = new DAOClient();
		return daos.recupClient();
	}
	

	public void assoSession(long idClient, long idSess) {
		DAOClient daos = new DAOClient();
		daos.assoSession(idClient,idSess);
	}
	public void removeSession(long idClient, long idSess) {
		DAOClient daos = new DAOClient();
		daos.removeSession(idClient,idSess);
	}


}
