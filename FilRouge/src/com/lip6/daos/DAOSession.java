package com.lip6.daos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.lip6.entities.Chapitre;
import com.lip6.entities.Evaluation;
import com.lip6.entities.Formation;
import com.lip6.entities.Salle;
import com.lip6.entities.Session;
import com.lip6.entities.TypeSession;
import com.lip6.util.JpaUtil;

public class DAOSession {
	public Set<Session> recupSession(){
		Set<Session> setSession = new HashSet<>();
		try {
			//JPQL --> renvoie la liste de toutes les sessions

			String requete = "SELECT se FROM Session se"; 

			
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
			Query query = em.createQuery(requete); 
			List<Session> results = query.getResultList();
			// je passe chaque element de la liste dans le set

			for (Session session : results) {
				System.out.println(session);
				setSession.add(session);

			}
			tx.commit();
			
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return setSession;
	}
	
	
	
	public boolean addSession(long idFormation ,String nomSession, Float prixSession , String dateDebut , String dateFin , String lieuSession ,TypeSession typesession) {
		
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
			Session se= new Session(nomSession, prixSession, dateDebut,dateFin, lieuSession, typesession);
			Evaluation eva=new Evaluation("prof");
			Formation form=em.find(Formation.class,idFormation);
			se.getEvaluations().add(eva);	
			se.setFormation(form);
			form.getSessions().add(se);
			em.persist(se);
							
			tx.commit();
			
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
}
public Session searchSession(long id) {
	Session se = new Session();
	try {
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();	
		se= em.find(Session.class, id);
		
		System.out.println(se);
		tx.commit();
		em.close();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return se;
	
}
public boolean removeSession(long id) {
	
	boolean success=false;
	try {
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();	
		Session se= em.find(Session.class, id);
		em.remove(se);
		tx. commit();
		em.close();
		
		success=true;
	} catch (Exception e) {
		e.printStackTrace();
	}

	return success;
}
public boolean updateSession(Session session) {
	
	boolean success=false;
	try {
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		em.merge(session);
		
		
		
		
		
		tx.commit();
		em.close();
		
		success=true;
	} catch (Exception e) {
		e.printStackTrace();
	}

	return success;
}

public void assoSalle(Long idSession, Long idSalle) {
	try {
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
			Salle salleASupprimer= em.find(Salle.class, idSalle);
			Session se= em.find(Session.class, idSession);
			se.setSalle(salleASupprimer);
			salleASupprimer.getSessions().add(se);
		
		tx.commit();
		
		em.close();
		
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
}
public void removeSalle(Long idSession, Long idSalle) {
	try {
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
			Salle salleASupprimer= em.find(Salle.class, idSalle);
			Session se= em.find(Session.class, idSession);
			se.setSalle(null);
			salleASupprimer.getSessions().remove(se);
		
		tx.commit();
		
		em.close();
		
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
}

}
