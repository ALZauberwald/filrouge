package com.lip6.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lip6.daos.DAOChapitre;
import com.lip6.daos.DAOSalle;
import com.lip6.daos.DAOSession;
import com.lip6.entities.Chapitre;
import com.lip6.entities.Salle;
import com.lip6.entities.Session;
import com.lip6.entities.TypeSession;
@Service("servSession")
public class SessionService {
	@Autowired
	@Qualifier("daoSession")
	DAOSession daoSession;
	
	public Set<Session> recupSession(){
		DAOSession daos = new DAOSession();
		return daos.recupSession();
	}
	
	public void createSession(long idFormation,String nomSession, Float prix, String dateDebut,String dateFin, String lieu, TypeSession typesession ) {
		daoSession.addSession(idFormation,nomSession,prix,dateDebut,dateFin,lieu,typesession);
	}
	public Session searchSession(long id) {
		return daoSession.searchSession(id);
	}
	public void removeSession(long id) {
		daoSession.removeSession(id);
	}
	public void updateSession(String champAModif, String modif  , long id) {
		//Récupération objet de la BDD
		Session session= daoSession.searchSession(id);
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
		
		daoSession.updateSession(session);
	}

	public void assoSalle(long idSess,long idSalle){
		daoSession.assoSalle(idSess, idSalle);
	}
	public void removeSalle(long idSess,long idSalle){
		daoSession.removeSalle(idSess, idSalle);
	}

	public void assoFormation(long idSess, long idFormation) {
		daoSession.assoFormation(idSess, idFormation);
		
	}

	public void removeFormation(long idSess, long idFormation) {
		daoSession.removeFormation(idSess, idFormation);
	}

	public void assoFormateur(long idSess, long idFormateur) {
		daoSession.assoFormateur(idSess, idFormateur);
		
	}

	public void removeFormateur(long idSess, long idFormateur) {
		daoSession.removeFormateur(idSess, idFormateur);
		
	}

	public void assoStagiaire(long idSess, long idStagiaire) {
		daoSession.assoStagiaire(idSess, idStagiaire);
		
	}

	public void removeStagiaire(long idSess, long idStagiaire) {
		daoSession.removeStagiaire(idSess, idStagiaire);
	}
	public void assoClient(long idSess, long idClient) {
		daoSession.assoClient(idSess, idClient);
		
	}

	public void removeClient(long idSess, long idClient) {
		daoSession.removeClient(idSess, idClient);
	}
}
