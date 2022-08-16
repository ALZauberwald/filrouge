package com.lip6.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lip6.daos.DAOFormation;
import com.lip6.daos.DAOSalle;
import com.lip6.daos.DAOSession;
import com.lip6.entities.Formation;
import com.lip6.entities.Salle;
import com.lip6.entities.Session;
import com.lip6.entities.TypeSession;

//passe plat vers le DAO
@Service("servFormation")
public class FormationService {
	@Autowired
	@Qualifier("daoFormation")
	DAOFormation daoFormation;
	
	public Set<Formation> recupFormations(){
		return daoFormation.recupFormation();
	}	
	
	public void assoSession(long idForm,long idSe){
		daoFormation.assoSession(idForm, idSe);
	}
	public void rmSession(long idForm,long idSe){
		daoFormation.removeSession(idForm, idSe);
	}
	public void assoTheme(long idForm,long idTh){
		daoFormation.assoTheme(idForm, idTh);
	}
	public void rmTheme(long idForm,long idTh){
		daoFormation.removeTheme(idForm, idTh);
	}
	public void assoChapitre(long idForm,long idChap){
		daoFormation.assoChapitre(idForm, idChap);
	}
	public void rmChapitre(long idForm,long idChap){
		daoFormation.removeChapitre(idForm, idChap);
	}
	
	public void assoPrerequis(long idForm,long idPr){
		daoFormation.assoPrerequis(idForm, idPr);
	}
	public void rmPrerequis(long idForm,long idPr){
		daoFormation.removePrerequis(idForm, idPr);
	}
	
	public void assoObjectif(long idForm,long idObj){
		daoFormation.assoObjectif(idForm, idObj);
	}
	public void rmObjectif(long idForm,long idObj){
		daoFormation.removeObjectif(idForm, idObj);
	}
	
	
	public void createFormation(String formationname,String formationdetail, String formationobjectif, String formationprerequis) {
		daoFormation.addFormation(formationname, formationdetail, formationobjectif, formationprerequis);
	}
	public Formation searchFormation(long id) {
		return daoFormation.searchFormation(id);
	}
	public void removeFormation(long id) {
		daoFormation.removeFormation(id);
	}

	public void updateFormation(String champAModif, String modif  , long id) {
		//Récupération objet de la BDD
		Formation formation= daoFormation.searchFormation(id);
		//modif
		if(champAModif.contentEquals("nom")) {
			formation.setNomFormation(modif);
		}
		else if(champAModif.contentEquals("detail")) {
			formation.setDetailFormation(modif);
		}		
		daoFormation.updateFormation(formation);
	}
		
	
	
	
	

}
