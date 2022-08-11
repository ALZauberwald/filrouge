package com.lip6.services;



import com.lip6.daos.DAOFormation;
import com.lip6.entities.Salle;
import com.lip6.entities.Session;
import com.lip6.entities.TypeSession;

//passe plat vers le DAO
public class FormationService {
	
	public void createFormation(String formationname,String formationdetail, String formationobjectif, String formationprerequis) {
		DAOFormation daof= new DAOFormation();
		daof.addFormation(formationname,formationdetail, formationobjectif, formationprerequis);
	}
	
}
