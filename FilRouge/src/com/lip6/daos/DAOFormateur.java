package com.lip6.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.lip6.entities.Formateur;
import com.lip6.entities.Session;
import com.lip6.entities.Personne;
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
	public Formateur searchFormateur(String nom , String prenom) {
		Formateur form = new Formateur();
		String requete = "SELECT id FROM Personne p WHERE Type='Formateur' AND p.nom ='"  + nom +"' AND p.prenom ='"+ prenom +"'";
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();	
		Query query = em.createQuery(requete);
		
		form = em.find(Formateur.class,query.getSingleResult());
		
		tx.commit();
		
		em.close();
		System.out.println(form);
		return form;
	}
	public boolean removeFormateur(String nom , String prenom) {
		boolean success = false;
		try {
		String requete = "SELECT id FROM Personne p WHERE Type='Formateur' AND p.nom ='"  + nom +"' AND p.prenom ='"+ prenom +"'";
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();	
		Query query = em.createQuery(requete);
		
		Formateur form = em.find(Formateur.class,query.getSingleResult());
		em.remove(form);
		tx.commit();
		
		em.close();
		success=true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	public boolean updateFormateur(Formateur formateur) {
		
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			
			em.merge(formateur);
			
			
			
			
			
			tx.commit();
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}

}
