package com.lip6.daos;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lip6.entities.Formation;
import com.lip6.entities.Session;
import com.lip6.entities.Theme;
import com.lip6.util.JpaUtil;


@Repository("daoTheme")
public class DAOTheme {
	public void assoSoustheme(Long idTheme, Long idSoustheme) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Theme th= em.find(Theme.class, idTheme);
				Theme sousthemeAAssocier= em.find(Theme.class, idSoustheme);
				th.getSousthemes().add(sousthemeAAssocier);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void removeSoustheme(Long idTheme, Long idSoustheme) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Theme th= em.find(Theme.class, idTheme);
				Theme sousthemeASupprimer= em.find(Theme.class, idSoustheme);
				th.getSousthemes().remove(sousthemeASupprimer);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void assoFormation(Long idTheme, Long idFormation) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Theme th= em.find(Theme.class, idTheme);
				Formation formationAAssocier= em.find(Formation.class, idFormation);
				th.getFormation().add(formationAAssocier);
				formationAAssocier.getTheme().add(th);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void removeFormation(Long idTheme, Long idFormation) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Theme th= em.find(Theme.class, idTheme);
				Formation formationASupprimer= em.find(Formation.class, idFormation);
				th.getFormation().remove(formationASupprimer);
				formationASupprimer.getTheme().remove(th);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Set<Theme> recupTheme(){
		Set<Theme> setTheme = new HashSet<>();
		try {

			//JPQL --> renvoie la liste de tous les Themes

			String requete = "SELECT th FROM Theme th"; 
			
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
			Query query = em.createQuery(requete); 
			List<Theme> results = query.getResultList();
			// je passe chaque element de la liste dans le set
			for (Theme theme : results) {
				setTheme.add(theme);
			}
			tx.commit();
			
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return setTheme;
	}
	
	
	public boolean addTheme(String themeName) {
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
				Theme th= new Theme(themeName);								
				em.persist(th);
			tx.commit();
			
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	

	public Theme searchTheme(long id) {
		Theme th = new Theme();
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
				th= em.find(Theme.class, id);
			tx.commit();
			em.close();		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return th;	
	}
	
public boolean removeTheme(long id) {	
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
				Theme th= em.find(Theme.class, id);
				em.remove(th);
			tx.commit();
			em.close();
			
			success=true;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}


public boolean updateTheme(Theme theme) {		
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				em.merge(theme);
			tx.commit();
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}	

	
}
