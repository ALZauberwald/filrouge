package com.lip6.services;

import com.lip6.daos.DAOFormation;
import com.lip6.daos.DAOSalle;
import com.lip6.daos.DAOSession;
import com.lip6.entities.Formation;
import com.lip6.entities.Salle;
import com.lip6.entities.Session;
import com.lip6.entities.TypeSession;

//passe plat vers le DAO
public class FormationService {
	public void assoChapitre(long idForm,long idChap){
		DAOFormation daof= new DAOFormation();
		daof.assoChapitre(idForm, idChap);
	}
	public void rmChapitre(long idForm,long idChap){
		DAOFormation daof= new DAOFormation();
		daof.removeChapitre(idForm, idChap);
	}
	
	public void assoPrerequis(long idForm,long idPr){
		DAOFormation daof= new DAOFormation();
		daof.assoPrerequis(idForm, idPr);
	}
	public void rmPrerequis(long idForm,long idPr){
		DAOFormation daof= new DAOFormation();
		daof.removePrerequis(idForm, idPr);
	}
	
	public void assoObjectif(long idForm,long idObj){
		DAOFormation daof= new DAOFormation();
		daof.assoObjectif(idForm, idObj);
	}
	public void rmObjectif(long idForm,long idObj){
		DAOFormation daof= new DAOFormation();
		daof.removeObjectif(idForm, idObj);
	}
	
	
	public void createFormation(String formationname,String formationdetail, String formationobjectif, String formationprerequis) {
		DAOFormation daof= new DAOFormation();
		daof.addFormation(formationname, formationdetail, formationobjectif, formationprerequis);
	}
	public Formation searchFormation(long id) {
		DAOFormation daos= new DAOFormation();
		return daos.searchFormation(id);
	}
	public void removeFormation(long id) {
		DAOFormation daos= new DAOFormation();
		daos.removeFormation(id);
	}

	public void updateFormation(String champAModif, String modif  , long id) {
		DAOFormation daos= new DAOFormation();
		//Récupération objet de la BDD
		Formation formation= daos.searchFormation(id);
		//modif
		if(champAModif.contentEquals("nom")) {
			formation.setNomFormation(modif);
		}
		else if(champAModif.contentEquals("detail")) {
			formation.setDetailFormation(modif);
		}		
		daos.updateFormation(formation);
	}
		
	
	
	
	

}
