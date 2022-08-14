package com.lip6.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.lip6.entities.Session;
import com.lip6.entities.Stagiaire;
import com.lip6.util.JpaUtil;

public class DAOStagiaire {
	public boolean addStagiaire(long idSession, String nom, String prenom, String adresse, String tel, String mail) {
		boolean success= false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
		
			tx.begin();	
			Session se=em.find(Session.class, idSession);
			Stagiaire st = new Stagiaire(nom, prenom, adresse, tel, mail);
			se.getStagiaires().add(st);
			st.getSessions().add(se);
			em.persist(st);
			
			tx.commit();
			
			em.close();
			
			
			success=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
}
