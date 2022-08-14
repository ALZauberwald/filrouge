package com.lip6.services;

import com.lip6.daos.DAOStagiaire;

public class StagiaireService {
	public void addStagiaire(long idSession, String nomStagiaire,String prenomStagiaire,String adresse,String tel,String mail){
		DAOStagiaire st = new DAOStagiaire();
		st.addStagiaire(idSession,nomStagiaire,prenomStagiaire,adresse,tel,mail);
		
	}
	public void searchStagiaire(String nom, String prenom) {
		DAOStagiaire st = new DAOStagiaire();
		st.searchStagiaire(nom,prenom);
	}
	public void removeStagiaire(String nom, String prenom) {
		DAOStagiaire st = new DAOStagiaire();
		st.removeStagiaire(nom,prenom);
	}
}
