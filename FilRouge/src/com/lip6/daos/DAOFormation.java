package com.lip6.daos;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

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


@Repository("daoFormation")
public class DAOFormation {
	public Set<Formation> recupFormation(){
		Set<Formation> setFormation = new HashSet<>();
		try {
			//JPQL --> renvoie la liste de toutes les formations

			String requete = "SELECT fm FROM Formation fm"; 

			
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
			Query query = em.createQuery(requete); 
			List<Formation> results = query.getResultList();
			// je passe chaque element de la liste dans le set

			for (Formation formation : results) {
				System.out.println(formation);
				setFormation.add(formation);

			}
			tx.commit();
			
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return setFormation;
	}
	
	
	public void assoSession(Long idForm, Long idSession) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Formation fo= em.find(Formation.class, idForm);
				Session sessAAssocier= em.find(Session.class, idSession);
				fo.getSessions().add(sessAAssocier);
				sessAAssocier.setFormation(fo);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void removeSession(Long idForm, Long idSession) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Formation fo= em.find(Formation.class, idForm);
				Session sessASupprimer= em.find(Session.class, idSession);
				fo.getSessions().remove(sessASupprimer);
				sessASupprimer.setFormation(null);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void assoTheme(Long idForm, Long idTheme) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Formation fo= em.find(Formation.class, idForm);
				Theme thAAssocier= em.find(Theme.class, idTheme);
				fo.getTheme().add(thAAssocier);
				thAAssocier.getFormation().add(fo);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void removeTheme(Long idForm, Long idTheme) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Formation fo= em.find(Formation.class, idForm);
				Theme thASupprimer= em.find(Theme.class, idTheme);
				fo.getTheme().remove(thASupprimer);
				thASupprimer.getFormation().remove(fo);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void assoChapitre(Long idForm, Long idChap) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Formation fo= em.find(Formation.class, idForm);
				Chapitre cpAAssocier= em.find(Chapitre.class, idChap);
				fo.getChapitres().add(cpAAssocier);
				cpAAssocier.setFormation(fo);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void removeChapitre(Long idForm, Long idChapitre) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Formation fo= em.find(Formation.class, idForm);
				Chapitre cpASupprimer= em.find(Chapitre.class, idChapitre);
				fo.getChapitres().remove(cpASupprimer);
				cpASupprimer.setFormation(null);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void assoPrerequis(Long idForm, Long idPrerequis) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Formation fo= em.find(Formation.class, idForm);
				Prerequis prAAssocier= em.find(Prerequis.class, idPrerequis);
				fo.getPrerequisFormation().add(prAAssocier);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removePrerequis(Long idForm, Long idPrerequis) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Formation fo= em.find(Formation.class, idForm);
				Prerequis prASupprimer= em.find(Prerequis.class, idPrerequis);
				fo.getPrerequisFormation().remove(prASupprimer);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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
	
	public void removeObjectif(Long idForm, Long idObj) {
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				Formation fo= em.find(Formation.class, idForm);
				Objectif obAAssocier= em.find(Objectif.class, idObj);
				fo.getObjectifsFormation().remove(obAAssocier);
			
			tx.commit();
			
			em.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Ajouter une nouvelle formation dans la base de donnï¿½e filrouge
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
				Theme st1= new Theme("Je suis destine a etre un sous theme");
				
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
				//suppression des associations avant de supprimer l'objet en base de donnée
				fm.setChapitres(null);
				fm.setObjectifsFormation(null);
				fm.setPrerequisFormation(null);
				fm.setSessions(null);
				fm.setTheme(null);
				
				String requetecp = "SELECT cp FROM Formation fm, Chapitre cp WHERE idFormation="+id; 
				Query querycp = em.createQuery(requetecp); 
				List<Chapitre> resultscp = querycp.getResultList();
				for (Chapitre chapitre : resultscp) {
					chapitre.setFormation(null);
				}
				//pas besoin, lien unidirectionnel
				//String requeteob = "SELECT ob FROM Formation fm, Objectif ob WHERE idFormation="+id;
				
				//pas besoin, lien unidirectionnel
				//String requetepr = "SELECT pr FROM Formation fm, Prerequis pr WHERE idFormation="+id; 
				
				String requetese = "SELECT se FROM Formation fm, Session se WHERE idFormation="+id; 
				Query queryse = em.createQuery(requetese); 
				List<Session> resultsse = queryse.getResultList();
				for (Session sess : resultsse) {
					sess.setFormation(null);
				}
				String requeteth = "SELECT th FROM Formation fm, Theme th WHERE idFormation="+id; 
				Query queryth = em.createQuery(requeteth); 
				List<Theme> resultsth = queryth.getResultList();
				for (Theme thme : resultsth) {
					thme.getFormation().remove(fm);
				}			
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
