package com.lip6.services;

import java.util.Set;

import com.lip6.daos.DAOChapitre;
import com.lip6.daos.DAOTheme;
import com.lip6.entities.Chapitre;

public class ChapitreService {
	public void assoFormation(long idChapitre,long idForm){
		DAOChapitre daot= new DAOChapitre();
		daot.assoFormation(idChapitre, idForm);
	}
	public void rmFormation(long idChapitre,long idForm){
		DAOChapitre daot= new DAOChapitre();
		daot.removeFormation(idChapitre, idForm);
	}
	
	
	public Set<Chapitre> recupChapitres(){
		DAOChapitre daof= new DAOChapitre();
		return daof.recupChapitre();
	}
	
	public void createChapitre(String chapitrename, int dureechapitre, String detailChapitre) {
		DAOChapitre daof= new DAOChapitre();
		daof.addChapitre(chapitrename, dureechapitre, detailChapitre);
	}
	public Chapitre searchChapitre(long id) {
		DAOChapitre daos= new DAOChapitre();
		return daos.searchChapitre(id);
	}
	public void removeChapitre(long id) {
		DAOChapitre daos= new DAOChapitre();
		daos.removeChapitre(id);
	}

	public void updateChapitre(String champAModif, String modif , long id) {
		DAOChapitre daos= new DAOChapitre();
		//Récupération objet de la BDD
		Chapitre chapitre= daos.searchChapitre(id);
		//modif
		if(champAModif.contentEquals("nom")) {
			chapitre.setNomChapitre(modif);
		}
		else if (champAModif.contentEquals("duree")) {
			int modifint= Integer.parseInt(modif);
			chapitre.setDureeChapitre(modifint);
		}
		else if (champAModif.contentEquals("detail")) {
			chapitre.setDetailChapitre(modif);
		}
		
		daos.updateChapitre(chapitre);
	}

	
	
}
