package com.lip6.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lip6.daos.DAOPrerequis;
import com.lip6.entities.Prerequis;

@Service("servPrerequis")
public class PrerequisService {
	@Autowired
	@Qualifier("daoPrerequis")
	DAOPrerequis daoPrerequis;

	public Set<Prerequis> recupPrerequis(){
		return daoPrerequis.recupPrerequis();
	}
	
	public void createPrerequis(String Prerequisname) {
		daoPrerequis.addPrerequis(Prerequisname);
	}
	public Prerequis searchPrerequis(long id) {
		return daoPrerequis.searchPrerequis(id);
	}
	public void removePrerequis(long id) {
		daoPrerequis.removePrerequis(id);
	}

	public void updatePrerequis(String champAModif, String modif , long id) {
		//Récupération objet de la BDD
		Prerequis Prerequis= daoPrerequis.searchPrerequis(id);
		//modif
		if(champAModif.contentEquals("nom")) {
			Prerequis.setNomPrerequis(modif);
		}
		daoPrerequis.updatePrerequis(Prerequis);
	}

	
	
}
