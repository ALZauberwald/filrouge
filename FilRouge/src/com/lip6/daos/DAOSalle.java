package com.lip6.daos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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
			System.out.println(sa.getSessions());
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
			System.out.println(sa.getSessions());
			tx.commit();
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
	public Set<Salle> recupSalle(){
		Set<Salle> setSalle = new HashSet<>();
		try {
			//JPQL --> renvoie la liste de toutes les formations

			String requete = "SELECT sa FROM Salle sa"; 

			
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
			Query query = em.createQuery(requete); 
			List<Salle> results = query.getResultList();
			// je passe chaque element de la liste dans le set

			for (Salle salle : results) {
				System.out.println(salle);
				setSalle.add(salle);

			}
			tx.commit();
			
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return setSalle;
	}
	public void assoSession(Long idSalle, Long idSession) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Salle sa= em.find(Salle.class, idSalle);
				Session sessAAssocier= em.find(Session.class, idSession);
				sa.getSessions().add(sessAAssocier);
				sessAAssocier.setSalle(sa);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void removeSession(Long idSalle, Long idSession) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Salle sa= em.find(Salle.class, idSalle);
				Session sessASupprimer= em.find(Session.class, idSession);
				sa.getSessions().remove(sessASupprimer);
				sessASupprimer.setSalle(null);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
