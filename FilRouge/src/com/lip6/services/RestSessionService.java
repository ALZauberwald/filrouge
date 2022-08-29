package com.lip6.services;

import java.util.Set;

import javax.ws.rs.Consumes;
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
	@Produces(MediaType.TEXT_HTML)
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
        	liste+="<br>"+st.toString();
        }
		return "<html>"+"<head>"+"<link rel=\"stylesheet\" href=\"../../../css/styles.css\">"+"<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\r\n"
				+"<title>"+"Liste"+"</title>"+"</head>"+"<body>"
				+"<header class=\"cd-main-header\">"+"<div class=\"logo\">"+"<a  href=\"../../../index.html\" title=\"formation informatique\">"
				+"<img src=\"../../../images/it-logo.png\" alt=\"Accueil ib formation\" width=\"100\">"+
				"</a>"+"</div>"+"</div>"+"<div class=\"topnav\">"+"<a href=\"../../../index.html\">"+"Home"+"</a>"+
		  		"<a href=\"#formations\">Formations</a>"+
		  		"<a href=\"#contact\">Contact</a>"+
		  		"<a href=\"#client\">Espace client</a>"+
		  		"<a href=\"#quisommenous\">Qui sommes-nous</a>"+
		  		"<input type=\"text\" placeholder=\"Search..\">"+
		  		"<a href=\"../../../accueilAdmin.jsp\">Accueil Admin</a>"+
		  		"</div>"+"</header>"+"<br>"+"<br>"+"<br>"+"<br>"+"<br>"+"<br>"+
		  		"<div class=\"but\">"+"<h2>"+"Session" + se.toString()+"</h2>" + "<br>" +"Nombre de stagiaires = " + String.valueOf(se.getStagiaires().size()) 
				+ "<br>" + "Liste des stagiaires pour cette session: " +"<br>" 
				+ liste+"</div>"+"<footer>"+ "<div>"+"<ul>"+"<h1>"+"Linkedin"+"</h1>"+
				"<li>"+"<a href=\"https://www.linkedin.com/in/caillej\"/>"+"Jeremy Caille"+"</a>"+"</li>"
				+"<li>"+"<a href=\"https://www.linkedin.com/in/alexandre-laurent-/\"/>"+"Alexandre Laurent"+"</a>"+"</li>"
				+"</ul>"+"</div>"+"</footer>"+"<body>"+"</html>";  
		
		}
	}
}
