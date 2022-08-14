package com.lip6.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.lip6.entities.Stagiaire;
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
	public Stagiaire searchStagiaire(String nom , String prenom) {
		Stagiaire stag = new Stagiaire();
		String requete = "SELECT id FROM Personne p WHERE Type='Stagiaire' AND p.nom ='"  + nom +"' AND p.prenom ='"+ prenom +"'";
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();	
		Query query = em.createQuery(requete);
		
		stag = em.find(Stagiaire.class,query.getSingleResult());
		
		tx.commit();
		
		em.close();
		System.out.println(stag);
		return stag;
	}
	public boolean removeStagiaire(String nom , String prenom) {
		boolean success = false;
		String requete = "SELECT id FROM Personne p WHERE Type='Stagiaire' AND p.nom ='"  + nom +"' AND p.prenom ='"+ prenom +"'";
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();	
		Query query = em.createQuery(requete);
		
		Stagiaire stag = em.find(Stagiaire.class,query.getSingleResult());
		em.remove(stag);
		tx.commit();
		
		em.close();
		return success;
	}
	public boolean updateStagiaire(Stagiaire stagiaire) {
		
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			
			em.merge(stagiaire);
			
			
			
			
			
			tx.commit();
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}

}
