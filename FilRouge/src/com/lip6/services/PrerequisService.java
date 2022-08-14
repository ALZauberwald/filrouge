package com.lip6.services;

import java.util.Set;

import com.lip6.daos.DAOPrerequis;
import com.lip6.entities.Prerequis;

public class PrerequisService {
	

	public Set<Prerequis> recupPrerequis(){

		DAOPrerequis daof= new DAOPrerequis();
		return daof.recupPrerequis();
	}
	
	public void createPrerequis(String Prerequisname) {
		DAOPrerequis daof= new DAOPrerequis();
		daof.addPrerequis(Prerequisname);
	}
	public Prerequis searchPrerequis(long id) {
		DAOPrerequis daos= new DAOPrerequis();
		return daos.searchPrerequis(id);
	}
	public void removePrerequis(long id) {
		DAOPrerequis daos= new DAOPrerequis();
		daos.removePrerequis(id);
	}

	public void updatePrerequis(String champAModif, String modif , long id) {
		DAOPrerequis daos= new DAOPrerequis();
		//Récupération objet de la BDD
		Prerequis Prerequis= daos.searchPrerequis(id);
		//modif
		if(champAModif.contentEquals("nom")) {
			Prerequis.setNomPrerequis(modif);
		}
		daos.updatePrerequis(Prerequis);
	}

	
	
}
