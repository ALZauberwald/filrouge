package com.lip6.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.lip6.entities.Evaluation;
import com.lip6.entities.Formation;
import com.lip6.entities.Objectif;
import com.lip6.entities.Prerequis;
import com.lip6.entities.Salle;
import com.lip6.entities.Session;
import com.lip6.entities.TypeSession;
import com.lip6.util.JpaUtil;



public class DAOFormation {

	//Ajouter une nouvelle formation dans la base de donnée filrouge
	public boolean addFormation(String formationname,String formationdetail, String formationobjectif, String formationprerequis) {
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
				Objectif ob= new Objectif(formationobjectif);	
				Prerequis pr= new Prerequis(formationprerequis);
				
				Formation newform= new Formation(formationname,ob,formationdetail, pr);
				
				//pour l'instant, lien onetoone à upgrader en lien one to many
				ob.setFormation(newform);
				pr.setFormation(newform);
				
				em.persist(newform);;
			tx.commit();
			
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}
	
	public boolean addSession(String nomSession, Float prixSession , String dateDebut , String lieuSession ,TypeSession typesession  ) {
		
			boolean success=false;
			try {
				EntityManager em=JpaUtil.getEmf().createEntityManager();	
				EntityTransaction tx = em.getTransaction();
				
				tx.begin();	
				Session se= new Session(nomSession, prixSession, dateDebut, lieuSession, typesession);
				Salle sa = new Salle("truc boulevard","103");
				Evaluation eva=new Evaluation("prof");
				
				se.setSalle(sa);
				se.getEvaluations().add(eva);
				
				em.persist(se);
								
				tx.commit();
				
				em.close();
				
				success=true;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return success;
	}
	
	
	
}
