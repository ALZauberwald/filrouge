package com.lip6.services;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.lip6.entities.Stagiaire;

@Service("rss")
@Path("/stagiaireservices")
public class RestStagiaireService {
GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();

	

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/{id}")
	public String searchStagiaire(@PathParam("id")  long idStagiaire) {
		System.out.println("*****************************************");
		Stagiaire st = new Stagiaire();
		ctx.load("classpath:applicationContext.xml"); 
		//si on ne refresh pas le context, une expression Spring sera levée
		ctx.refresh();
	
		StagiaireService ss=ctx.getBean("servStagiaire", StagiaireService.class);
		
		if (ss==null)
			System.out.println("///////////////////////////////////////////////////////******");
		else
			st=ss.searchStagiaire(idStagiaire);
		//System.out.println(contact);
		return st.toString();
	}
	@GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
		ctx.load("classpath:applicationContext.xml"); 
		//si on ne refresh pas le context, une expression Spring sera levée
		ctx.refresh();
		String liste ="";
		String sautLigne= System.getProperty("line.separator");
		StagiaireService ss=ctx.getBean("servStagiaire", StagiaireService.class);
        Set<Stagiaire> stag= ss.recupStagiaire();
        for(Stagiaire st : stag) {
        	liste+=sautLigne +st.toString();
        }
        return "Nombre de Stagiaires = " + String.valueOf(stag.size()) + sautLigne +"Liste de Stagiaires:"+liste ;
    }
	
}
