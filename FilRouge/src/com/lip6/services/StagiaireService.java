package com.lip6.services;

import com.lip6.daos.DAOStagiaire;
import com.lip6.entities.Stagiaire;

public class StagiaireService {
	public void addStagiaire(long idSession, String nomStagiaire,String prenomStagiaire,String adresse,String tel,String mail){
		DAOStagiaire st = new DAOStagiaire();
		st.addStagiaire(idSession,nomStagiaire,prenomStagiaire,adresse,tel,mail);
		
	}
	public Stagiaire searchStagiaire(String nom, String prenom) {
		DAOStagiaire st = new DAOStagiaire();
		return st.searchStagiaire(nom,prenom);
	}
	public void removeStagiaire(String nom, String prenom) {
		DAOStagiaire st = new DAOStagiaire();
		st.removeStagiaire(nom,prenom);
	}
	public void updateStagiaire(String nom,String prenom, String champAModif, String modif) {
		DAOStagiaire daos = new DAOStagiaire();
		
		Stagiaire stag = daos.searchStagiaire(nom, prenom);
		
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
	
}
