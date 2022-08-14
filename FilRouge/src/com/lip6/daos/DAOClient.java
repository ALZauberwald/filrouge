package com.lip6.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.lip6.entities.Client;
import com.lip6.util.JpaUtil;

public class DAOClient {
	public boolean addClient(String nom, String prenom, String adresse, String tel, String mail, String numSiret) {
		boolean success= false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
		
			tx.begin();	
			Client cl = new Client(nom, prenom, adresse, tel, mail, numSiret);
			em.persist(cl);
			
			tx.commit();
			
			em.close();
			
			
			success=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
}
