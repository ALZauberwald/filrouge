package com.lip6.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lip6.daos.DAOFormateur;
import com.lip6.entities.Formateur;
@Service("servFormateur")
public class FormateurService {
	@Autowired
	@Qualifier("daoFormateur")
	DAOFormateur daoFormateur;
	
	public void addFormateur(String nomFormateur,String prenomFormateur,String adresse,String tel,String mail,String dateEmbauche){
		
		daoFormateur.addFormateur(nomFormateur,prenomFormateur,adresse,tel,mail,dateEmbauche);
		
	}
	public Formateur searchFormateur(Long idFormateur) {
		
		return daoFormateur.searchFormateur(idFormateur);
	}
		
	public void removeFormateur(Long idFormateur) {
		
		daoFormateur.removeFormateur(idFormateur);
	}
	public void updateFormateur(Long idFormateur, String champAModif, String modif) {
				
		Formateur form = daoFormateur.searchFormateur(idFormateur);
		
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
		else if(champAModif.contentEquals("embauche")) {
			form.setDateEmbauche(modif);
		}
		daoFormateur.updateFormateur(form);
		
	}
	public Set<Formateur> recupFormateur(){ 
		DAOFormateur daoFormateur = new DAOFormateur();
		return daoFormateur.recupFormateur();
	}
	public void assoSession(long idFormateur, long idSess) {
		
		daoFormateur.assoSession(idFormateur,idSess);
	}
	public void removeSession(long idFormateur, long idSess) {
		
		daoFormateur.removeSession(idFormateur,idSess);
	}
	
}
