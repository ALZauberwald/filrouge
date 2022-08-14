package com.lip6.services;

import java.util.Set;

import com.lip6.daos.DAOTheme;
import com.lip6.entities.Theme;

public class ThemeService {
	
	public Set<Theme> recupTheme(){
		DAOTheme daof= new DAOTheme();
		return daof.recupTheme();
	}
	
	public void createTheme(String themeName) {
		DAOTheme daof= new DAOTheme();
		daof.addTheme(themeName);
	}
	public Theme searchTheme(long id) {
		DAOTheme daos= new DAOTheme();
		return daos.searchTheme(id);
	}
	public void removeTheme(long id) {
		DAOTheme daos= new DAOTheme();
		daos.removeTheme(id);
	}

	public void updateTheme(String champAModif, String modif , long id) {
		DAOTheme daos= new DAOTheme();
		//Récupération objet de la BDD
		Theme theme= daos.searchTheme(id);
		//modif
		if(champAModif.contentEquals("nom")) {
			theme.setNomTheme(modif);
		}
		daos.updateTheme(theme);
	}

	
	
}
