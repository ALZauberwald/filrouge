package com.lip6.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.lip6.entities.Formateur;
import com.lip6.entities.Session;
import com.lip6.util.JpaUtil;

public class DAOFormateur {
	public boolean addFormateur(String nom, String prenom, String adresse, String tel, String mail, String dateEmbauche) {
		boolean success= false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
		
			tx.begin();	
			Formateur fo = new Formateur(nom, prenom, adresse, tel, mail, dateEmbauche);
			em.persist(fo);
			
			tx.commit();
			
			em.close();
			
			
			success=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
}
