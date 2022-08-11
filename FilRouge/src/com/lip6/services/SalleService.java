package com.lip6.services;

import com.lip6.daos.DAOSalle;
import com.lip6.entities.Salle;

public class SalleService {
	public void addSalle(String adresse , String nomSalle ) {
		DAOSalle daos=new DAOSalle();
		daos.addSalle(adresse, nomSalle);
	}
	
	public Salle searchSalle(long id) {
		DAOSalle daos=new DAOSalle();
		return daos.searchSalle(id);
		
	}
	
	public void removeSalle(long id) {
		DAOSalle daos=new DAOSalle();
		daos.removeSalle(id);
	}
	public void updateSalle(long id,String adresse , String nomSalle ) {
		DAOSalle daos=new DAOSalle();
		Salle sa = daos.searchSalle(id);
		sa.setAdresse(adresse);
		sa.setNomSalle(nomSalle);
		daos.updateSalle(sa);
	}
	
}
