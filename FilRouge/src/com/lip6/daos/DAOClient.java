package com.lip6.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.lip6.entities.Client;
import com.lip6.entities.Session;
import com.lip6.entities.Client;
import com.lip6.util.JpaUtil;

public class DAOClient {
	public boolean addClient(long idSession,String nom, String prenom, String adresse, String tel, String mail, String numSiret) {
		boolean success= false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
		
			tx.begin();
			Session se=em.find(Session.class, idSession);
			Client cl = new Client(nom, prenom, adresse, tel, mail, numSiret);
			cl.getSessions().add(se);
			se.getClient().add(cl);
			em.persist(cl);
			
			tx.commit();
			
			em.close();
			
			
			success=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public Client searchClient(String nom , String prenom) {
		Client cl = new Client();
		try {
		String requete = "SELECT id FROM Personne p WHERE Type='Client' AND p.nom ='"  + nom +"' AND p.prenom ='"+ prenom +"'";
		
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();	
		Query query = em.createQuery(requete);
		
		cl = em.find(Client.class,query.getSingleResult());
		
		tx.commit();
		
		em.close();
		System.out.println(cl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cl;
	}
	public boolean removeClient(String nom , String prenom) {
		boolean success = false;
		try {
		String requete = "SELECT id FROM Personne p WHERE Type='Client' AND p.nom ='"  + nom +"' AND p.prenom ='"+ prenom +"'";
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();	
		Query query = em.createQuery(requete);
		
		Client stag = em.find(Client.class,query.getSingleResult());
		em.remove(stag);
		tx.commit();
		
		em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	public boolean updateClient(Client client) {
		
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			
			em.merge(client);
			
			
			
			
			
			tx.commit();
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}

}
