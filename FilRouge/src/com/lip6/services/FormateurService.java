package com.lip6.services;

import java.util.Set;

import com.lip6.daos.DAOFormateur;
import com.lip6.entities.Formateur;

public class FormateurService {
	public void addFormateur(String nomFormateur,String prenomFormateur,String adresse,String tel,String mail,String dateEmbauche){
		DAOFormateur fm = new DAOFormateur();
		fm.addFormateur(nomFormateur,prenomFormateur,adresse,tel,mail,dateEmbauche);
		
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
	public Set<Formateur> recupFormateur(){ 
		DAOFormateur daos = new DAOFormateur();
		return daos.recupFormateur();
	}
	public void assoSession(long idFormateur, long idSess) {
		DAOFormateur daos = new DAOFormateur();
		daos.assoSession(idFormateur,idSess);
	}
	public void removeSession(long idFormateur, long idSess) {
		DAOFormateur daos = new DAOFormateur();
		daos.removeSession(idFormateur,idSess);
	}
}
