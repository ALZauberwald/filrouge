package com.lip6.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.lip6.entities.Evaluation;
import com.lip6.entities.Formation;
import com.lip6.entities.Salle;
import com.lip6.entities.Session;
import com.lip6.entities.TypeSession;
import com.lip6.util.JpaUtil;

public class DAOSession {
	public boolean addSession(long idFormation ,String nomSession, Float prixSession , String dateDebut , String dateFin , String lieuSession ,TypeSession typesession, long idSalle  ) {
		
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
			Session se= new Session(nomSession, prixSession, dateDebut,dateFin, lieuSession, typesession);
			Salle sa = em.find(Salle.class, idSalle);
			Evaluation eva=new Evaluation("prof");
			
			Formation form=em.find(Formation.class,idFormation);
			se.setSalle(sa);
			se.getEvaluations().add(eva);
			sa.getSessions().add(se);	
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

}
