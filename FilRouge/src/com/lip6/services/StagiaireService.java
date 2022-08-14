package com.lip6.services;

import com.lip6.daos.DAOStagiaire;

public class StagiaireService {
	public void addStagiaire(long idSession, String nomStagiaire,String prenomStagiaire,String adresse,String tel,String mail){
		DAOStagiaire st = new DAOStagiaire();
		st.addStagiaire(idSession,nomStagiaire,prenomStagiaire,adresse,tel,mail);
		
	}
}
