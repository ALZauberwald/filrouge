package com.lip6.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.lip6.entities.Salle;
import com.lip6.entities.Session;
import com.lip6.util.JpaUtil;

public class DAOSalle {
	public boolean addSalle(String adresse , String nomSalle  ) {
		
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
			Salle sa = new Salle(adresse,nomSalle);
			em.persist(sa);
							
			tx.commit();
			
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}
	public Salle searchSalle(long id) {
		Salle sa = new Salle();
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
			sa= em.find(Salle.class, id);
			
			System.out.println(sa);
			
			em.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sa;
		
	}
	public boolean removeSalle(long id) {
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
			Salle sa= em.find(Salle.class, id);
			em.remove(sa);
			tx.commit();
			
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success=true;
	}
	public boolean updateSalle(Salle salle) {
		
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			
			em.merge(salle);
			
			
			
			
			
			tx.commit();
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}
}
