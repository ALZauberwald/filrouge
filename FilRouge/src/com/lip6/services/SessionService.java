package com.lip6.services;

import com.lip6.daos.DAOSalle;
import com.lip6.daos.DAOSession;
import com.lip6.entities.Salle;
import com.lip6.entities.Session;
import com.lip6.entities.TypeSession;

public class SessionService {
	public void createSession(long idFormation,String nomSession, Float prix, String dateDebut,String dateFin, String lieu, TypeSession typesession , long IdSalle) {
		DAOSession daos= new DAOSession();
		daos.addSession(idFormation,nomSession,prix,dateDebut,dateFin,lieu,typesession,IdSalle);
	}
	public Session searchSession(long id) {
		DAOSession daos= new DAOSession();
		return daos.searchSession(id);
	}
	public void removeSession(long id) {
		DAOSession daos= new DAOSession();
		daos.removeSession(id);
	}
	public void updateSession(String champAModif, String modif  , long id) {
		DAOSession daos= new DAOSession();
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
		else if(champAModif.contentEquals("installationFinie")) {
			if(modif.contentEquals("true")){
				session.setInstallationFinie(true);
			}
			else
				session.setInstallationFinie(false);
		}
		else if(champAModif.contentEquals("idSalle")) {
			DAOSalle daosSalle= new DAOSalle();
			Salle sa=daosSalle.searchSalle(Long.parseLong(modif));
			session.setSalle(sa);
		}
		
		daos.updateSession(session);
	}
}
