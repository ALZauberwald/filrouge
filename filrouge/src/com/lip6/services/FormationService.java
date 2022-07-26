package com.lip6.services;

import com.lip6.daos.DAOFormation;

//passe plat vers le DAO
public class FormationService {
	
	public void createFormation(String formationname,String formationdetail, String formationobjectif, String formationprerequis) {
		DAOFormation daof= new DAOFormation();
		daof.addFormation(formationname,formationdetail, formationobjectif, formationprerequis);
	}

}
