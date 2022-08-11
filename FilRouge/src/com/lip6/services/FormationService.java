package com.lip6.services;

import com.lip6.daos.DAOFormation;
import com.lip6.entities.Formation;
import com.lip6.entities.Salle;
import com.lip6.entities.Session;
import com.lip6.entities.TypeSession;

//passe plat vers le DAO
public class FormationService {
	
	public void createFormation(String formationname,String formationdetail, String formationobjectif, String formationprerequis) {
		DAOFormation daof= new DAOFormation();
		daof.addFormation(formationname, formationdetail, formationobjectif, formationprerequis);
	}
	public Formation searchFormation(long id) {
		DAOFormation daos= new DAOFormation();
		return daos.searchFormation(id);
	}
	public void removeFormation(long id) {
		System.out.println("j'arrive ici quand meme ( formationservice)");
		DAOFormation daos= new DAOFormation();
		daos.removeFormation(id);
	}
	public void updateFormation(String champAModif, String modif  , long id) {
		
		}
	
	
	
	
	public void createSession(long idFormation,String nomSession, Float prix, String dateDebut, String lieu, TypeSession typesession , String adresse , String nomSalle) {
		DAOFormation daos= new DAOFormation();
		daos.addSession(idFormation,nomSession,prix,dateDebut,lieu,typesession,adresse,nomSalle);
	}
	public Session searchSession(long id) {
		DAOFormation daos= new DAOFormation();
		return daos.searchSession(id);
	}
	public void removeSession(long id) {
		DAOFormation daos= new DAOFormation();
		daos.removeSession(id);
	}
	public void updateSession(String champAModif, String modif  , long id) {
		DAOFormation daos= new DAOFormation();
		//Récupération objet de la BDD
		Session session= daos.searchSession(id);
		System.out.println(session.getSalle()+"*************************************");
		//modif
		if(champAModif.contentEquals("nomSession")) {
			session.setNomSession(modif);
		}
		else if(champAModif.contentEquals("prix")) {
			session.setPrix(Float.parseFloat(modif));
		}
		else if(champAModif.contentEquals("dateDebut")) {
			session.setDateDebut(modif);
		}
		else if(champAModif.contentEquals("lieu")) {
			session.setLieu(modif);
		}
		else if(champAModif.contentEquals("formateurConfirmé")) {
			if(modif.contentEquals("true")){
				session.setFormateurConfirme(true);
			}
			else
				session.setFormateurConfirme(false);
		}
		else if(champAModif.contentEquals("typeSession")) {
			if(modif.equals("inter entreprise"))
				session.setTypeSession(TypeSession.INTER_ENTREPRISE);
			else if(modif.equals("intra entreprise"))
				session.setTypeSession(TypeSession.INTRA_ENTREPRISE);
			else if(modif.equals("perso"))
				session.setTypeSession(TypeSession.PERSONNALISEE);
		}
		else if(champAModif.contentEquals("adresse")) {
			Salle sa = new Salle(modif,session.getSalle().getNomSalle());
			session.setSalle(sa);
			sa.getSessions().add(session);
			
		}
		else if(champAModif.contentEquals("nomSalle")) {
			Salle sa = new Salle(session.getSalle().getAdresse(),modif);
			session.setSalle(sa);
			sa.getSessions().add(session);
		}
		else if(champAModif.contentEquals("installationFinie")) {
			if(modif.contentEquals("true")){
				session.getSalle().setInstallationFinie(true);
			}
			else
				session.getSalle().setInstallationFinie(false);
		}
		
		
		
		
		
		
		
		
		daos.updateSession(session,id);
	}
}
