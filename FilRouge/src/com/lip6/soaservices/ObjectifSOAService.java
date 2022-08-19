package com.lip6.soaservices;

import java.util.Set;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.lip6.daos.DAOObjectif;
import com.lip6.entities.Objectif;
import com.lip6.services.ObjectifService;


@Path("/objectif")
public class ObjectifSOAService {

	DAOObjectif daoObjectif= new DAOObjectif();
	ObjectifService observ = new ObjectifService();
	
	public Set<Objectif> recupObjectifs(){
		return daoObjectif.recupObjectif();
	}
	
	public void createObjectif(String objectifname) {
		System.out.println("#####################################JE passe par la ###################################");
		daoObjectif.addObjectif(objectifname);
	}
	@Path("/recherche/{id}")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Objectif searchObjectif(@PathParam("id") long id) {
		System.out.println("2222222222222222222222J'arrive dans soaobjectif.searchobjectif juste avant l'appel d'objectifservice id="+id);
		return  daoObjectif.searchObjectif(id);
	}
	public void removeObjectif(long id) {
		daoObjectif.removeObjectif(id);
	}

	public void updateObjectif(String champAModif, String modif , long id) {
		//Récupération objet de la BDD
		Objectif objectif= daoObjectif.searchObjectif(id);
		//modif
		if(champAModif.contentEquals("nom")) {
			objectif.setNomObjectif(modif);
		}
		daoObjectif.updateObjectif(objectif);
	}
	
	
}
