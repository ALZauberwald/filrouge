package com.lip6.daos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.lip6.entities.Session;
import com.lip6.entities.Client;
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
	public Set<Client> recupClient(){
		Set<Client> setClient = new HashSet<>();
		try {
			//JPQL --> renvoie la liste de toutes les Clients

			String requete = "SELECT sa FROM Client sa"; 

			
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
			Query query = em.createQuery(requete); 
			List<Client> results = query.getResultList();
			// je passe chaque element de la liste dans le set

			for (Client client : results) {
				System.out.println(client);
				setClient.add(client);

			}
			tx.commit();
			
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return setClient;
	}

	public void assoSession(long idClient, long idSess) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Client clientAAssocier= em.find(Client.class, idClient);
				Session se= em.find(Session.class, idSess);
				se.getClient().add(clientAAssocier);
				clientAAssocier.getSessions().add(se);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeSession(long idClient, long idSess) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Client clientASupprimer= em.find(Client.class, idClient);
				Session se= em.find(Session.class, idSess);
				se.getClient().remove(clientASupprimer);
				clientASupprimer.getSessions().remove(se);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
