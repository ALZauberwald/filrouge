package com.lip6.daos;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.lip6.entities.Chapitre;
import com.lip6.entities.Formation;
import com.lip6.entities.Theme;
import com.lip6.util.JpaUtil;



public class DAOChapitre {
	public void assoFormation(Long idChapitre, Long idFormation) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Chapitre cp= em.find(Chapitre.class, idChapitre);
				Formation formationAAssocier= em.find(Formation.class, idFormation);
				cp.setFormation(formationAAssocier);
				formationAAssocier.getChapitres().add(cp);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void removeFormation(Long idChapitre, Long idFormation) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Chapitre cp= em.find(Chapitre.class, idChapitre);
				Formation formationASupprimer= em.find(Formation.class, idFormation);
				cp.setFormation(null);
				formationASupprimer.getChapitres().remove(cp);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Set<Chapitre> recupChapitre(){
		Set<Chapitre> setChapitre = new HashSet<>();
		try {
			//JPQL --> renvoie la liste de tous les Chapitres

			String requete = "SELECT cp FROM Chapitre cp"; 

			
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
			Query query = em.createQuery(requete); 
			List<Chapitre> results = query.getResultList();
			// je passe chaque element de la liste dans le set

			for (Chapitre chapitre : results) {
				System.out.println(chapitre);
				setChapitre.add(chapitre);

			}
			tx.commit();
			
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return setChapitre;
	}
	
	
	public boolean addChapitre(String chapitrename, int dureeChapitre, String detailChapitre) {
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
				Chapitre cp= new Chapitre(chapitrename, dureeChapitre, detailChapitre);								
				em.persist(cp);
			tx.commit();
			
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	

	public Chapitre searchChapitre(long id) {
		Chapitre ob = new Chapitre();
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
				ob= em.find(Chapitre.class, id);
			tx.commit();
			em.close();		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return ob;	
	}
	
public boolean removeChapitre(long id) {	
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
				Chapitre ob= em.find(Chapitre.class, id);
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


public boolean updateChapitre(Chapitre Chapitre) {		
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				em.merge(Chapitre);
			tx.commit();
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}	

	
}
