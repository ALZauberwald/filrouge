package com.lip6.services;

import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.lip6.daos.DAOStagiaire;
import com.lip6.entities.Stagiaire;
@Path("/createStagiaire")
@Service("servStagiaire")
public class StagiaireService {
	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	
	@Autowired
	@Qualifier("daoStagiaire")
	DAOStagiaire daoStagiaire;
	
	@POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addStagiaire(@FormParam("idSession") Long idSession,
    		@FormParam("nom") String nomStagiaire,
            @FormParam("prenom") String prenomStagiaire,
            @FormParam("adresse") String adresse,
            @FormParam("tel")String tel,
            @FormParam("email") String mail,
            @Context HttpServletResponse servletResponse) throws IOException {
        System.out.println("Le nom du stagiaire est "+nomStagiaire);
        ctx.load("classpath:application-annotations.xml"); 
		ctx.refresh();
		StagiaireService ss = ctx.getBean("servStagiaire",StagiaireService.class);
		ss.addStagiaire(idSession, nomStagiaire, prenomStagiaire, adresse, tel, mail);
        servletResponse.sendRedirect("../index.html");
    }
	public void addStagiaire(long idSession, String nomStagiaire,String prenomStagiaire,String adresse,String tel,String mail){
		daoStagiaire.addStagiaire(idSession,nomStagiaire,prenomStagiaire,adresse,tel,mail);
		
	}
	public Stagiaire searchStagiaire(long idStagiaire) {
		return daoStagiaire.searchStagiaire(idStagiaire);
	}
	public void removeStagiaire(long idStagiaire) {
		daoStagiaire.removeStagiaire(idStagiaire);
	}
	public void updateStagiaire(long id, String champAModif, String modif) {
		
		Stagiaire stag = daoStagiaire.searchStagiaire(id);
		
		if(champAModif.contentEquals("nom")) {
			stag.setNom(modif);
		}
		else if(champAModif.contentEquals("prenom")) {
			stag.setPrenom(modif);
		}
		else if(champAModif.contentEquals("adresse")) {
			stag.setAdresse(modif);
		}
		else if(champAModif.contentEquals("tel")) {
			stag.setTel(modif);
		}
		else if(champAModif.contentEquals("mail")) {
			stag.setMail(modif);
		}
		daoStagiaire.updateStagiaire(stag);
	}
	public Set<Stagiaire> recupStagiaire(){ 
		return daoStagiaire.recupStagiaire();
	}
	public void assoSession(long idStagiaire, long idSess) {
		daoStagiaire.assoSession(idStagiaire,idSess);
	}
	
	public void removeSession(long idStagiaire, long idSess) {
		daoStagiaire.removeSession(idStagiaire,idSess);
		
	}	
}
