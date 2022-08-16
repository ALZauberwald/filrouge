package com.lip6.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lip6.daos.DAOClient;
import com.lip6.entities.Client;
@Service("servClient")
public class ClientService {
	@Autowired
	@Qualifier("daoClient")
	DAOClient daoClient;
	public void addClient(long idSession,String nomClient,String prenomClient,String adresse,String tel,String mail,String numSiret){
		
		daoClient.addClient(idSession,nomClient,prenomClient,adresse,tel,mail,numSiret);
		
	}


	public Client searchClient(Long idClient) {
		return daoClient.searchClient(idClient);
	}


	public void removeClient(long idClient) {
		daoClient.removeClient(idClient);
	}
	
	public void updateClient(long idClient , String champAModif , String modif) {
		
		Client cl = daoClient.searchClient(idClient);
		
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
		daoClient.updateClient(cl);
	}
	public Set<Client> recupClient(){ 
		
		return daoClient.recupClient();
	}
	

	public void assoSession(long idClient, long idSess) {
		daoClient.assoSession(idClient,idSess);
	}
	public void removeSession(long idClient, long idSess) {
		daoClient.removeSession(idClient,idSess);
	}


}
