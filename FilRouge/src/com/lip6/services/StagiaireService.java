package com.lip6.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lip6.daos.DAOStagiaire;
import com.lip6.entities.Stagiaire;
@Service("servStagiaire")
public class StagiaireService {
	@Autowired
	@Qualifier("daoStagiaire")
	DAOStagiaire daoStagiaire;
	
	public void addStagiaire(long idSession, String nomStagiaire,String prenomStagiaire,String adresse,String tel,String mail){
		daoStagiaire.addStagiaire(idSession,nomStagiaire,prenomStagiaire,adresse,tel,mail);
		
	}
	public Stagiaire searchStagiaire(long idStagiaire) {
		return daoStagiaire.searchStagiaire(idStagiaire);
	}
	public void removeStagiaire(long idStagiaire) {
		daoStagiaire.removeStagiaire(idStagiaire);
	}
	public void updateStagiaire(long id, String champAModif, String modif) {
		
		Stagiaire stag = daoStagiaire.searchStagiaire(id);
		
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
		daoStagiaire.updateStagiaire(stag);
	}
	public Set<Stagiaire> recupStagiaire(){ 
		DAOStagiaire daoStagiaire = new DAOStagiaire();
		return daoStagiaire.recupStagiaire();
	}
	public void assoSession(long idStagiaire, long idSess) {
		daoStagiaire.assoSession(idStagiaire,idSess);
	}
	
	public void removeSession(long idStagiaire, long idSess) {
		daoStagiaire.removeSession(idStagiaire,idSess);
		
	}	
}
