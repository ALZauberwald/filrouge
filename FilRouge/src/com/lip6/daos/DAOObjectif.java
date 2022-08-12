package com.lip6.daos;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.lip6.entities.Objectif;
import com.lip6.util.JpaUtil;



public class DAOObjectif {
	
	public Set<Objectif> recupObjectif(){
		Set<Objectif> setObjectif = new HashSet<>();
		try {
			//JPQL --> renvoie la liste de tous les objectifs
			String requete = "SELECT ob FROM Objectif ob"; 
			
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
			Query query = em.createQuery(requete); 
			List<Objectif> results = query.getResultList();
			// je passe chaque element de la liste dans le set
			for (Objectif objectif : results) {
				System.out.println(objectif);
				setObjectif.add(objectif);
			}
			tx.commit();
			
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return setObjectif;
	}
	
	
	public boolean addObjectif(String objectifname) {
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
				Objectif ob= new Objectif(objectifname);								
				em.persist(ob);
			tx.commit();
			
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	

	public Objectif searchObjectif(long id) {
		Objectif ob = new Objectif();
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
				ob= em.find(Objectif.class, id);
			tx.commit();
			em.close();		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return ob;	
	}
	
public boolean removeObjectif(long id) {	
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
				Objectif ob= em.find(Objectif.class, id);
				em.remove(ob);
			tx.commit();
			em.close();
			
			success=true;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}


public boolean updateObjectif(Objectif objectif) {		
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				em.merge(objectif);
			tx.commit();
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}	

	
}
