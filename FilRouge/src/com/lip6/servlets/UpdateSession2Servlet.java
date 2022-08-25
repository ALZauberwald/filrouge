package com.lip6.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lip6.services.ClientService;
import com.lip6.services.FormateurService;
import com.lip6.services.FormationService;
import com.lip6.services.SalleService;
import com.lip6.services.SessionService;
import com.lip6.services.StagiaireService;

/**
 * Servlet implementation class UpdateSession2Servlet
 */
@WebServlet("/UpdateSession2Servlet")
public class UpdateSession2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSession2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		String[] allBeanNames = context.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
            System.out.println(beanName + "******************");
        }
        SessionService session = context.getBean("servSession",SessionService.class);
        ClientService cs = context.getBean("servClient",ClientService.class);
        FormateurService fs = context.getBean("servFormateur",FormateurService.class);
        SalleService salle = context.getBean("servSalle",SalleService.class);
        StagiaireService stagiaire = context.getBean("servStagiaire",StagiaireService.class);
        FormationService formserv = context.getBean("servFormation",FormationService.class);
        

		long idSess= Long.parseLong(request.getParameter("idSession"));
		
		String choix = request.getParameter("choix");
		if(choix.equals("assoSalle")) {
			long idsalle= Long.parseLong(request.getParameter("idSalle"));
			session.assoSalle(idSess, idsalle);
		}
		else if (choix.equals("rmSalle")) {
			long idSessSa= Long.parseLong(request.getParameter("idSessRm"));
			long idsalle= Long.parseLong(request.getParameter("idSalleRm"));
			session.removeSalle(idSessSa,idsalle );
		}
		else if(choix.equals("assoFormation")) {
			long idFormation= Long.parseLong(request.getParameter("idFormation"));
			session.assoFormation(idSess, idFormation);
		}
		else if (choix.equals("rmFormation")) {
			long idSessFo= Long.parseLong(request.getParameter("idSessRm"));
			long idFormation= Long.parseLong(request.getParameter("idFormationRm"));
			session.removeFormation(idSessFo,idFormation );
		}
		else if(choix.equals("assoFormateur")) {
			long idFormateur= Long.parseLong(request.getParameter("idFormateur"));
			session.assoFormateur(idSess, idFormateur);
		}
		else if (choix.equals("rmFormateur")) {
			long idSessFo= Long.parseLong(request.getParameter("idSessRm"));
			long idFormateur= Long.parseLong(request.getParameter("idFormateurRm"));
			session.removeFormateur(idSessFo,idFormateur );
		}
		else if(choix.equals("assoStagiaire")) {
			long idStagiaire= Long.parseLong(request.getParameter("idStagiaire"));
			session.assoStagiaire(idSess, idStagiaire);
		}
		else if (choix.equals("rmStagiaire")) {
			long idSessSt= Long.parseLong(request.getParameter("idSessRm"));
			long idStagiaire= Long.parseLong(request.getParameter("idStagiaireRm"));
			session.removeStagiaire(idSessSt,idStagiaire );
		}
		else if(choix.equals("assoClient")) {
			long idClient= Long.parseLong(request.getParameter("idClient"));
			session.assoClient(idSess, idClient);
		}
		else if (choix.equals("rmClient")) {
			long idSessCl= Long.parseLong(request.getParameter("idSessRm"));
			long idClient= Long.parseLong(request.getParameter("idClientRm"));
			session.removeClient(idSessCl,idClient );
		}
		request.setAttribute("sess",session.searchSession(idSess));
		request.setAttribute("sallesdisponibles",salle.recupSalle());
		request.setAttribute("formationsdisponibles",formserv.recupFormations());
		request.setAttribute("formateursdisponibles",fs.recupFormateur());
		request.setAttribute("clientsdisponibles",cs.recupClient());
		request.setAttribute("stagiairesdisponibles",stagiaire.recupStagiaire());
		
		RequestDispatcher rd= request.getRequestDispatcher("infosession.jsp") ;
		rd.forward(request, response);
	}

}
