package com.lip6.services;

import com.lip6.daos.DAOFormateur;
import com.lip6.entities.Formateur;

public class FormateurService {
	public void addFormateur(String nomStagiaire,String prenomStagiaire,String adresse,String tel,String mail,String dateEmbauche){
		DAOFormateur fm = new DAOFormateur();
		fm.addFormateur(nomStagiaire,prenomStagiaire,adresse,tel,mail,dateEmbauche);
		
	}
	public Formateur searchFormateur(String nom, String prenom) {
		DAOFormateur fm = new DAOFormateur();
		return fm.searchFormateur(nom, prenom);
	}
	public void removeFormateur(String nom, String prenom) {
		DAOFormateur fm = new DAOFormateur();
		fm.removeFormateur(nom, prenom);
	}
	public void updateFormateur(String nom, String prenom, String champAModif, String modif) {
DAOFormateur daos = new DAOFormateur();
		
		Formateur form = daos.searchFormateur(nom, prenom);
		
		if(champAModif.contentEquals("nom")) {
			form.setNom(modif);
		}
		else if(champAModif.contentEquals("prenom")) {
			form.setPrenom(modif);
		}
		else if(champAModif.contentEquals("adresse")) {
			form.setAdresse(modif);
		}
		else if(champAModif.contentEquals("tel")) {
			form.setTel(modif);
		}
		else if(champAModif.contentEquals("mail")) {
			form.setMail(modif);
		}
		else if(champAModif.contentEquals("siret")) {
			form.setDateEmbauche(modif);
		}
		daos.updateFormateur(form);
		
	}
}
