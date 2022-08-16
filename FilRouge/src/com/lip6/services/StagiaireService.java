package com.lip6.services;

import java.util.Set;

import com.lip6.daos.DAOStagiaire;
import com.lip6.entities.Stagiaire;

public class StagiaireService {
	public void addStagiaire(long idSession, String nomStagiaire,String prenomStagiaire,String adresse,String tel,String mail){
		DAOStagiaire st = new DAOStagiaire();
		st.addStagiaire(idSession,nomStagiaire,prenomStagiaire,adresse,tel,mail);
		
	}
	public Stagiaire searchStagiaire(long idStagiaire) {
		DAOStagiaire st = new DAOStagiaire();
		return st.searchStagiaire(idStagiaire);
	}
	public void removeStagiaire(long idStagiaire) {
		DAOStagiaire daos = new DAOStagiaire();
		daos.removeStagiaire(idStagiaire);
	}
	public void updateStagiaire(long id, String champAModif, String modif) {
		DAOStagiaire daos = new DAOStagiaire();
		
		Stagiaire stag = daos.searchStagiaire(id);
		
		if(champAModif.contentEquals("nom")) {
			stag.setNom(modif);
		}
		else if(champAModif.contentEquals("prenom")) {
			stag.setPrenom(modif);
		}
		else if(champAModif.contentEquals("adresse")) {
			stag.setAdresse(modif);
		}
		else if(champAModif.contentEquals("tel")) {
			stag.setTel(modif);
		}
		else if(champAModif.contentEquals("mail")) {
			stag.setMail(modif);
		}
		daos.updateStagiaire(stag);
	}
	public Set<Stagiaire> recupStagiaire(){ 
		DAOStagiaire daos = new DAOStagiaire();
		return daos.recupStagiaire();
	}
	public void assoSession(long idStagiaire, long idSess) {
		DAOStagiaire daos = new DAOStagiaire();
		daos.assoSession(idStagiaire,idSess);
	}
	
	public void removeSession(long idStagiaire, long idSess) {
		DAOStagiaire daos = new DAOStagiaire();
		daos.removeSession(idStagiaire,idSess);
		
	}	
}
