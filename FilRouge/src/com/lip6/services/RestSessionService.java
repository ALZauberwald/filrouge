package com.lip6.services;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lip6.entities.Session;
import com.lip6.entities.Stagiaire;
@Path("/sessionservices")
public class RestSessionService {
	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/count/{id}")
	public String searchStagiaireSession(@PathParam("id")  long idSession) {
		System.out.println("*****************************************");
		Session se = new Session();
		ctx.load("classpath:applicationContext.xml"); 
		//si on ne refresh pas le context, une expression Spring sera levée
		ctx.refresh();
	
		SessionService ss=ctx.getBean("servSession", SessionService.class);
		
		String liste ="";
		String sautLigne= System.getProperty("line.separator");
		se=ss.searchSession(idSession);
		if(se==null) {
			return "La session que vous recherchez n'existe pas";
		}
		else {
			
		
        for(Stagiaire st : se.getStagiaires()) {
        	liste+=sautLigne +st.toString();
        }
		//System.out.println(contact);
		return "Session " + se.toString() + sautLigne + "Nombre de stagiaires = " + String.valueOf(se.getStagiaires().size()) + sautLigne + "Liste des stagiaires pour cette session: " +sautLigne + liste;  
		
		}
	}
}
