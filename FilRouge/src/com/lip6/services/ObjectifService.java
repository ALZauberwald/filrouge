package com.lip6.services;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lip6.daos.DAOObjectif;
import com.lip6.entities.Objectif;


@Service("servObjectif")
public class ObjectifService {
	@Autowired
	@Qualifier("daoObjectif")
	DAOObjectif daoObjectif;
	
//ObjectifSOAService objsoa= new ObjectifSOAService();
	
	public Set<Objectif> recupObjectifs(){
		return daoObjectif.recupObjectif();
	}
	
	public void createObjectif(String objectifname) {
		daoObjectif.addObjectif(objectifname);
	}
	public Objectif searchObjectif(long id) {
		
		return daoObjectif.searchObjectif(id);
		
		
	}
	public void removeObjectif(long id) {
		daoObjectif.removeObjectif(id);
	}

	public void updateObjectif(String champAModif, String modif , long id) {
		//Récupération objet de la BDD
		Objectif objectif= daoObjectif.searchObjectif(id);
		//modif
		if(champAModif.contentEquals("nom")) {
			objectif.setNomObjectif(modif);
		}
		daoObjectif.updateObjectif(objectif);
	}

	
	
}
