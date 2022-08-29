package com.lip6.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lip6.daos.DAOChapitre;
import com.lip6.daos.DAOSalle;
import com.lip6.daos.DAOTheme;
import com.lip6.entities.Chapitre;

@Service("servChapitre")
public class ChapitreService {
	@Autowired
	@Qualifier("daoChapitre")
	DAOChapitre daoChapitre;
	
	public void assoFormation(long idChapitre,long idForm){
		daoChapitre.assoFormation(idChapitre, idForm);
	}
	public void rmFormation(long idChapitre,long idForm){
		daoChapitre.removeFormation(idChapitre, idForm);
	}
	
	
	public Set<Chapitre> recupChapitres(){
		return daoChapitre.recupChapitre();
	}
	
	public void createChapitre(String chapitrename, int dureechapitre, String detailChapitre) {
		daoChapitre.addChapitre(chapitrename, dureechapitre, detailChapitre);
	}
	public Chapitre searchChapitre(long id) {
		return daoChapitre.searchChapitre(id);
	}
	public void removeChapitre(long id) {
		daoChapitre.removeChapitre(id);
	}

	public void updateChapitre(String champAModif, String modif , long id) {

		//Récupération objet de la BDD
		Chapitre chapitre= daoChapitre.searchChapitre(id);
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
		
		daoChapitre.updateChapitre(chapitre);
	}

	
	
}
