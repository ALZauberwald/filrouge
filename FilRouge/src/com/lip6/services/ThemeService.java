package com.lip6.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lip6.daos.DAOTheme;
import com.lip6.entities.Theme;

@Service("servTheme")
public class ThemeService {
	@Autowired
	@Qualifier("daoTheme")
	DAOTheme daoTheme;
	
	public void assoSoustheme(long idTheme,long idSoustheme){
		daoTheme.assoSoustheme(idTheme, idSoustheme);
	}
	public void rmSoustheme(long idTheme,long idSoustheme){
		daoTheme.removeSoustheme(idTheme, idSoustheme);
	}
	
	public void assoFormation(long idTheme,long idForm){
		daoTheme.assoFormation(idTheme, idForm);
	}
	public void rmFormation(long idTheme,long idForm){
		daoTheme.removeFormation(idTheme, idForm);
	}
	
	public Set<Theme> recupTheme(){
		return daoTheme.recupTheme();
	}
	
	public void createTheme(String themeName) {
		daoTheme.addTheme(themeName);
	}
	public Theme searchTheme(long id) {
		return daoTheme.searchTheme(id);
	}
	public void removeTheme(long id) {
		daoTheme.removeTheme(id);
	}

	public void updateTheme(String champAModif, String modif , long id) {
		//Récupération objet de la BDD
		Theme theme= daoTheme.searchTheme(id);
		//modif
		if(champAModif.contentEquals("nom")) {
			theme.setNomTheme(modif);
		}
		daoTheme.updateTheme(theme);
	}

	
	
}
