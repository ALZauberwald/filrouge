package com.lip6.daos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lip6.entities.Chapitre;
import com.lip6.entities.Client;
import com.lip6.entities.Evaluation;
import com.lip6.entities.Formateur;
import com.lip6.entities.Formation;
import com.lip6.entities.Salle;
import com.lip6.entities.Session;
import com.lip6.entities.Stagiaire;
import com.lip6.entities.TypeSession;
import com.lip6.util.JpaUtil;
@Repository("daoSession")
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

public void assoSalle(Long idSess, Long idSalle) {
	try {
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
			Salle salleAAssocier= em.find(Salle.class, idSalle);
			Session se= em.find(Session.class, idSess);
			se.setSalle(salleAAssocier);
			salleAAssocier.getSessions().add(se);
		
		tx.commit();
		
		em.close();
		
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
}
public void removeSalle(Long idSess, Long idSalle) {
	try {
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
			Salle salleASupprimer= em.find(Salle.class, idSalle);
			Session se= em.find(Session.class, idSess);
			se.setSalle(null);
			salleASupprimer.getSessions().remove(se);
		
		tx.commit();
		
		em.close();
		
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
}



public void assoFormation(long idSess, long idFormation) {
	try {
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
			Formation formationAAssocier= em.find(Formation.class, idFormation);
			Session se= em.find(Session.class, idSess);
			se.setFormation(formationAAssocier);
			formationAAssocier.getSessions().add(se);
		
		tx.commit();
		
		em.close();
		
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	
}
public void removeFormation(long idSess, long idFormation) {
	try {
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
			Formation formationASupprimer= em.find(Formation.class, idFormation);
			Session se= em.find(Session.class, idSess);
			se.setFormation(null);
			formationASupprimer.getSessions().remove(se);
		
		tx.commit();
		
		em.close();
		
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	
}



public void assoFormateur(long idSess, long idFormateur) {
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

public void removeFormateur(long idSess, long idFormateur) {
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



public void assoStagiaire(long idSess, long idStagiaire) {
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



public void removeStagiaire(long idSess, long idStagiaire) {
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



public void assoClient(long idSess, long idClient) {
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



public void removeClient(long idSess, long idClient) {
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
