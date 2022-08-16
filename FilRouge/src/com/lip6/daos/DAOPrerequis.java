package com.lip6.daos;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lip6.entities.Prerequis;
import com.lip6.util.JpaUtil;


@Repository("daoPrerequis")
public class DAOPrerequis {
	
	public Set<Prerequis> recupPrerequis(){
		Set<Prerequis> setPrerequis = new HashSet<>();
		try {

			//JPQL --> renvoie la liste de tous les Prerequis

			String requete = "SELECT pr FROM Prerequis pr"; 
			
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
			Query query = em.createQuery(requete); 
			List<Prerequis> results = query.getResultList();
			// je passe chaque element de la liste dans le set
			for (Prerequis Prerequis : results) {
				setPrerequis.add(Prerequis);
			}
			tx.commit();
			
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return setPrerequis;
	}
	
	
	public boolean addPrerequis(String Prerequisname) {
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
				Prerequis ob= new Prerequis(Prerequisname);								
				em.persist(ob);
			tx.commit();
			
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	

	public Prerequis searchPrerequis(long id) {
		Prerequis ob = new Prerequis();
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
				ob= em.find(Prerequis.class, id);
			tx.commit();
			em.close();		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return ob;	
	}
	
public boolean removePrerequis(long id) {	
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
				Prerequis ob= em.find(Prerequis.class, id);
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


public boolean updatePrerequis(Prerequis Prerequis) {		
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				em.merge(Prerequis);
			tx.commit();
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}	

	
}
