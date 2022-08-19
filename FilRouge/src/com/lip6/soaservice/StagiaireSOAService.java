package com.lip6.soaservice;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lip6.entities.Stagiaire;
import com.lip6.services.StagiaireService;


import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;


//@Path("/stagiaire")
public class StagiaireSOAService  {
	StagiaireService stag = new StagiaireService();
//	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();

//	@POST
//    @Produces(MediaType.TEXT_HTML)
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    public void newStagiaire(@FormParam("idSession") long idSession,
//    		@FormParam("nom") String nom,
//            @FormParam("prenom") String prenom,
//            @FormParam("adresse") String adresse,
//            @FormParam("tel") String tel,
//            @FormParam("mail") String mail,
//            @Context HttpServletResponse servletResponse) throws IOException {
//		StagiaireService stag=ctx.getBean("servStagiaire", StagiaireService.class);
//		stag.addStagiaire(idSession, nom, prenom, adresse, tel, mail);
//
//        servletResponse.sendRedirect("../ad");
//    }
	
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	@Path("/{id}")
//	public String searchStagiaire(@PathParam("id")  long idStagiaire) {
//		System.out.println("*****************************************");
//		
//		ctx.load("classpath:applicationContext.xml"); 
//		//si on ne refresh pas le context, une expression Spring sera levée
//		ctx.refresh();
//	
//		StagiaireService stag=ctx.getBean("servStagiaire", StagiaireService.class);
//		
//		if (stag==null)
//			System.out.println("///////////////////////////////////////////////////////******");
//		else
//			stag.searchStagiaire(idStagiaire);
//		System.out.println(stag  + "/////////////////////////////////////");
//		return "test ok";
//	}
//	
	
//	@GET
//	@Produces(MediaType.TEXT_HTML)
//	@Path("/{id}")
	
	
}