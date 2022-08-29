package com.lip6.daos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lip6.entities.Formateur;
import com.lip6.entities.Formation;
import com.lip6.entities.Session;
import com.lip6.util.JpaUtil;
@Repository("daoFormateur")
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
	public Formateur searchFormateur(Long idFormateur) {
		Formateur form = new Formateur();
		try {
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();		
		form = em.find(Formateur.class,idFormateur);
		
		tx.commit();
		
		em.close();
		System.out.println(form);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return form;
	}
	public boolean removeFormateur(Long idFormateur) {
		boolean success = false;
		try {
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();	
		
		Formateur form = em.find(Formateur.class,idFormateur);

		form.setSessions(null);
		String requetefo = "SELECT se FROM Personne , Session se WHERE Type='Formateur' AND id="+idFormateur; 
        Query queryfo = em.createQuery(requetefo); 
        List<Session> resultsfo = queryfo.getResultList();
        for (Session sess : resultsfo) {
            sess.setFormateur(null);
        }
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
	public Set<Formateur> recupFormateur(){
		Set<Formateur> setFormateur = new HashSet<>();
		try {
			//JPQL --> renvoie la liste de toutes les formations

			String requete = "SELECT sa FROM Formateur sa"; 

			
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
			Query query = em.createQuery(requete); 
			List<Formateur> results = query.getResultList();
			// je passe chaque element de la liste dans le set

			for (Formateur formateur : results) {
				System.out.println(formateur);
				setFormateur.add(formateur);

			}
			tx.commit();
			
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return setFormateur;
	}
	public void assoSession(long idFormateur, long idSess) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Formateur formateurAAssocier= em.find(Formateur.class, idFormateur);
				Session se= em.find(Session.class, idSess);
				se.setFormateur(formateurAAssocier);
				formateurAAssocier.getSessions().add(se);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void removeSession(long idFormateur, long idSess) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Formateur formateurASupprimer= em.find(Formateur.class, idFormateur);
				Session se= em.find(Session.class, idSess);
				se.setFormateur(null);
				formateurASupprimer.getSessions().remove(se);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
