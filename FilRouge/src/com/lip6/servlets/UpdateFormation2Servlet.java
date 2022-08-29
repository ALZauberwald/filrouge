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

import com.lip6.daos.DAOFormation;
import com.lip6.entities.Formation;
import com.lip6.entities.Salle;
import com.lip6.entities.Session;
import com.lip6.entities.TypeSession;
import com.lip6.services.ChapitreService;
import com.lip6.services.FormationService;
import com.lip6.services.ObjectifService;
import com.lip6.services.PrerequisService;
import com.lip6.services.SessionService;
import com.lip6.services.ThemeService;

/**
 * Servlet implementation class UpdateSessionServlet
 */
@WebServlet("/UpdateFormation2Servlet")
public class UpdateFormation2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFormation2Servlet() {
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
			String choix = request.getParameter("choix");
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			FormationService forma = context.getBean("servFormation",FormationService.class);
			ObjectifService objectifserv = context.getBean("servObjectif",ObjectifService.class);
			PrerequisService prerequisserv = context.getBean("servPrerequis",PrerequisService.class);
			ChapitreService chapitreserv = context.getBean("servChapitre",ChapitreService.class);
			ThemeService themeserv = context.getBean("servTheme",ThemeService.class);
			SessionService sessionserv = context.getBean("servSession",SessionService.class);
			
			long idform= Long.parseLong(request.getParameter("idFormation"));
			
			if(choix.equals("asso")) {
				long idObj= Long.parseLong(request.getParameter("idObjectif"));
				forma.assoObjectif(idform, idObj);
			}
			else if (choix.equals("rm")) {
				long idformOb= Long.parseLong(request.getParameter("idFormationRm"));
				long idObj= Long.parseLong(request.getParameter("idObjectifRm"));
				forma.rmObjectif(idformOb, idObj);
			}
			else if(choix.equals("assoPrerequis")) {
				long idPr= Long.parseLong(request.getParameter("idPrerequis"));
				forma.assoPrerequis(idform, idPr);
			}
			else if (choix.equals("rmPrerequis")) {
				long idformPr= Long.parseLong(request.getParameter("idFormationRm"));
				long idPr= Long.parseLong(request.getParameter("idPrerequisRm"));
				forma.rmPrerequis(idformPr, idPr);
			}
			else if(choix.equals("assoChapitre")) {
				long idChap= Long.parseLong(request.getParameter("idChapitre"));
				forma.assoChapitre(idform, idChap);
			}
			else if (choix.equals("rmChapitre")) {
				long idformCh= Long.parseLong(request.getParameter("idFormationRm"));
				long idChap= Long.parseLong(request.getParameter("idChapitreRm"));
				forma.rmChapitre(idformCh, idChap);
			}
			else if(choix.equals("assoTheme")) {
				long idTh= Long.parseLong(request.getParameter("idTheme"));
				forma.assoTheme(idform, idTh);
			}
			else if (choix.equals("rmTheme")) {
				long idformTh= Long.parseLong(request.getParameter("idFormationRm"));
				long idth= Long.parseLong(request.getParameter("idThemeRm"));
				forma.rmTheme(idformTh, idth);
			}
			else if(choix.equals("assoSession")) {
				long idformSe= Long.parseLong(request.getParameter("idFormation"));
				long idsess= Long.parseLong(request.getParameter("idSession"));
				forma.assoSession(idformSe, idsess);
			}
			else if (choix.equals("rmSession")) {
				long idformSe= Long.parseLong(request.getParameter("idFormationRm"));
				long idsess= Long.parseLong(request.getParameter("idSessionRm"));
				forma.rmSession(idformSe, idsess);
			}
			request.setAttribute("form",forma.searchFormation(idform));
			request.setAttribute("objectifsdisponibles", objectifserv.recupObjectifs());
			request.setAttribute("prerequisdisponibles", prerequisserv.recupPrerequis());
			request.setAttribute("chapitresdisponibles", chapitreserv.recupChapitres());
			request.setAttribute("themesdisponibles", themeserv.recupTheme());
			request.setAttribute("sessionsdisponibles", sessionserv.recupSession());

			RequestDispatcher rd= request.getRequestDispatcher("infoformation.jsp") ;
			rd.forward(request, response);
	}

}
