package com.lip6.services;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lip6.daos.DAOObjectif;
import com.lip6.entities.Objectif;
import com.lip6.soaservices.ObjectifSOAService;


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
		System.out.println("3333333333333333333333333333J'arrive dans objectifservcice.searchobjectif juste avant  l'appel d'objectifdao ici id ="+id);
		ObjectifSOAService obsoa=new ObjectifSOAService();
		Objectif de= obsoa.searchObjectif(id);
		System.out.println("J'arrive a la fin de objectifservice88888888888888888888888888888888888888888888888888888888888888888888888888888");
		return de;
		
		
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
