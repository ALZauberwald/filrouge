package com.lip6.services;

import java.util.Set;

import com.lip6.daos.DAOObjectif;
import com.lip6.entities.Objectif;

public class ObjectifService {
	
	public Set<Objectif> recupObjectifs(){
		DAOObjectif daof= new DAOObjectif();
		return daof.recupObjectif();
	}
	
	public void createObjectif(String objectifname) {
		DAOObjectif daof= new DAOObjectif();
		daof.addObjectif(objectifname);
	}
	public Objectif searchObjectif(long id) {
		DAOObjectif daos= new DAOObjectif();
		return daos.searchObjectif(id);
	}
	public void removeObjectif(long id) {
		DAOObjectif daos= new DAOObjectif();
		daos.removeObjectif(id);
	}

	public void updateObjectif(String champAModif, String modif , long id) {
		DAOObjectif daos= new DAOObjectif();
		//Récupération objet de la BDD
		Objectif objectif= daos.searchObjectif(id);
		//modif
		if(champAModif.contentEquals("nom")) {
			objectif.setNomObjectif(modif);
		}
		daos.updateObjectif(objectif);
	}

	
	
}
