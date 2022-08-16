package com.lip6.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lip6.daos.DAOSalle;
import com.lip6.entities.Salle;
@Service("servSalle")
public class SalleService {
	@Autowired
	@Qualifier("daoSalle")
	DAOSalle daoSalle;
	
	
	public void addSalle(String adresse , String nomSalle ) {
		
		daoSalle.addSalle(adresse, nomSalle);
	}
	
	public Salle searchSalle(long id) {
		return daoSalle.searchSalle(id);
		
	}
	
	public void removeSalle(long id) {
		daoSalle.removeSalle(id);
	}
	public void updateSalle(long id,String adresse , String nomSalle ) {
		Salle sa = daoSalle.searchSalle(id);
		sa.setAdresse(adresse);
		sa.setNomSalle(nomSalle);
		daoSalle.updateSalle(sa);
	}
	public Set<Salle> recupSalle(){
		DAOSalle daoSalle= new DAOSalle();
		return daoSalle.recupSalle();
	}
	public void assoSession(long idSalle,long idSe){
		daoSalle.assoSession(idSalle, idSe);
	}
	public void removeSession(long idSalle,long idSe){
		daoSalle.removeSession(idSalle, idSe);
	}
}
