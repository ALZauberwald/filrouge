package com.lip6.services;

import com.lip6.daos.DAOClient;

public class ClientService {
	public void addClient(String nomStagiaire,String prenomStagiaire,String adresse,String tel,String mail,String numSiret){
		DAOClient dc = new DAOClient();
		dc.addClient(nomStagiaire,prenomStagiaire,adresse,tel,mail,numSiret);
		
	}
}
