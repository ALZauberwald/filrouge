package com.lip6.services;

import com.lip6.daos.DAOFormateur;

public class FormateurService {
	public void addFormateur(String nomStagiaire,String prenomStagiaire,String adresse,String tel,String mail,String dateEmbauche){
		DAOFormateur fm = new DAOFormateur();
		fm.addFormateur(nomStagiaire,prenomStagiaire,adresse,tel,mail,dateEmbauche);
		
	}
}
