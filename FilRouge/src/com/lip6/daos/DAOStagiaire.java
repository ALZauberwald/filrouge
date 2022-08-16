package com.lip6.daos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	public Stagiaire searchStagiaire(long id) {
		Stagiaire stag = new Stagiaire();
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			
			stag = em.find(Stagiaire.class, id);
			
			
			tx.commit();
			
			em.close();
			System.out.println(stag);
		}catch (Exception e) {
			e.printStackTrace();
		}
			return stag;
	}
	public boolean removeStagiaire(long idStagiaire) {
		boolean success = false;
		try{
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();	
		
		Stagiaire stag = em.find(Stagiaire.class,idStagiaire);
		em.remove(stag);
		tx.commit();
		
		em.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
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
	public Set<Stagiaire> recupStagiaire(){
		Set<Stagiaire> setStagiaire = new HashSet<>();
		try {
			//JPQL --> renvoie la liste de toutes les Stagiaires

			String requete = "SELECT sa FROM Stagiaire sa"; 

			
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
			Query query = em.createQuery(requete); 
			List<Stagiaire> results = query.getResultList();
			// je passe chaque element de la liste dans le set

			for (Stagiaire stagiaire : results) {
				System.out.println(stagiaire);
				setStagiaire.add(stagiaire);

			}
			tx.commit();
			
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return setStagiaire;
	}
	public void assoSession(long idStagiaire, long idSess) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Stagiaire stagiaireAAssocier= em.find(Stagiaire.class, idStagiaire);
				Session se= em.find(Session.class, idSess);
				se.getStagiaires().add(stagiaireAAssocier);
				stagiaireAAssocier.getSessions().add(se);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void removeSession(long idStagiaire, long idSess) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Stagiaire stagiaireASupprimer= em.find(Stagiaire.class, idStagiaire);
				Session se= em.find(Session.class, idSess);
				se.getStagiaires().remove(stagiaireASupprimer);
				stagiaireASupprimer.getSessions().remove(se);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	}
