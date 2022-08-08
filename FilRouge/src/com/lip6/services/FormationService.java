package com.lip6.services;



import com.lip6.daos.DAOFormation;
import com.lip6.entities.Session;
import com.lip6.entities.TypeSession;

//passe plat vers le DAO
public class FormationService {
	
	public void createFormation(String formationname,String formationdetail, String formationobjectif, String formationprerequis) {
		DAOFormation daof= new DAOFormation();
		daof.addFormation(formationname,formationdetail, formationobjectif, formationprerequis);
	}
	public void createSession(long idFormation,String nomSession, Float prix, String dateDebut, String lieu, TypeSession typesession , String adresse , String nomSalle) {
		DAOFormation daos= new DAOFormation();
		daos.addSession(idFormation,nomSession,prix,dateDebut,lieu,typesession,adresse,nomSalle);
	}
	public Session searchSession(long id) {
		DAOFormation daos= new DAOFormation();
		return daos.searchSession(id);
	}
	public void removeSession(long id) {
		DAOFormation daos= new DAOFormation();
		daos.removeSession(id);
	}
	public void updateSession(Session s , long id) {
		DAOFormation daos= new DAOFormation();
		daos.updateSession(s,id);
	}
}
