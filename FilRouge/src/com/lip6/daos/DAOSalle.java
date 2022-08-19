package com.lip6.daos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.lip6.entities.Salle;
import com.lip6.entities.Session;
import com.lip6.util.JpaUtil;
@Repository("daoSalle")
public class DAOSalle {
//	@Autowired
//	@Qualifier("classeSalle")
//	Salle salle;
	public boolean addSalle(String adresse , String nomSalle  ) {
		
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			tx.begin();	
			Salle salle = new Salle(adresse,nomSalle);
//			salle.setAdresse(adresse);
//			salle.setNomSalle(nomSalle);
			em.persist(salle);
//			em.merge(salle);
							
			tx.commit();
			
			em.close();
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}
	public Salle searchSalle(long id) {
		Salle salle = new Salle();
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
			salle= em.find(Salle.class, id);
			
			tx.commit();
			em.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salle;
		
	}
	public boolean removeSalle(long id) {
		  boolean success=false;
	        try {
	            EntityManager em=JpaUtil.getEmf().createEntityManager();
	            EntityTransaction tx = em.getTransaction();

	            tx.begin();
	                Salle sa= em.find(Salle.class, id);

	                sa.setSessions(null);

	                String requete = "SELECT se FROM Session se, Salle WHERE idSalle= "+id; 
	                Query query = em.createQuery(requete); 
	                List<Session> results = query.getResultList();
	                for (Session session : results) {
	                    session.setSalle(null);
	                }

	                em.remove(sa);
	            tx.commit();
	            em.close();

	            success=true;
	        } 
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        return success;
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

			String requete = "SELECT salle FROM Salle salle"; 

			
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
				Salle salle= em.find(Salle.class, idSalle);
				Session sessAAssocier= em.find(Session.class, idSession);
				salle.getSessions().add(sessAAssocier);
				sessAAssocier.setSalle(salle);
			
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
				Salle salle= em.find(Salle.class, idSalle);
				Session sessASupprimer= em.find(Session.class, idSession);
				salle.getSessions().remove(sessASupprimer);
				sessASupprimer.setSalle(null);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
