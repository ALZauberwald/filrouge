package com.lip6.daos;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.lip6.entities.Evaluation;
import com.lip6.entities.Formation;
import com.lip6.entities.Objectif;
import com.lip6.entities.Prerequis;
import com.lip6.entities.Salle;
import com.lip6.entities.Session;
import com.lip6.entities.TypeSession;
import com.lip6.entities.Chapitre;

import com.lip6.entities.Theme;
import com.lip6.util.JpaUtil;



public class DAOFormation {
	public void assoObjectif(Long idForm, Long idObj) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Formation fo= em.find(Formation.class, idForm);
				Objectif obAAssocier= em.find(Objectif.class, idObj);
				fo.getObjectifsFormation().add(obAAssocier);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Ajouter une nouvelle formation dans la base de donn�e filrouge
	public boolean addFormation(String formationname,String formationdetail, String formationobjectif, String formationprerequis) {
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
				Objectif ob= new Objectif(formationobjectif);				
				Prerequis pr= new Prerequis(formationprerequis);				
				Chapitre cp= new Chapitre("chapitre test", 5, "Ce chapitre n'existe pas vraiment :)");
				Theme tm = new Theme("theme test");
				Theme st1= new Theme("Je suis destin� � �tre un sous theme");
				
				Formation newform= new Formation(formationname,formationdetail);
				
				newform.getObjectifsFormation().add(ob);						
				newform.getPrerequisFormation().add(pr);
				newform.getChapitres().add(cp);
				cp.setFormation(newform);
				newform.getTheme().add(tm);
				tm.getFormation().add(newform);
				tm.getSousthemes().add(st1);
										
				em.persist(newform);;
			tx.commit();
			
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}
	

	public Formation searchFormation(long id) {
		Formation fm = new Formation();
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
			fm= em.find(Formation.class, id);
			tx.commit();
			em.close();		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return fm;	
	}
	
public boolean removeFormation(long id) {	
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
			Formation fm= em.find(Formation.class, id);
			em.remove(fm);
			tx.commit();
			em.close();
			
			success=true;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}


public boolean updateFormation(Formation formation) {		
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			em.merge(formation);
			tx.commit();
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}	

	
}
