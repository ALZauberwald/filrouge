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
@WebServlet("/UpdateFormationServlet")
public class UpdateFormationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFormationServlet() {
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
		// TODO Auto-generated method stub
			
			String champAModif = request.getParameter("champAModif");
			String modif = request.getParameter("modif");
			String idstr = request.getParameter("idFormation");
			long idform = Long.parseLong(idstr);
			
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			FormationService forma = context.getBean("servFormation",FormationService.class);
			ObjectifService objectifserv = context.getBean("servObjectif",ObjectifService.class);
			PrerequisService prerequisserv = context.getBean("servPrerequis",PrerequisService.class);
			ChapitreService chapitreserv = context.getBean("servChapitre",ChapitreService.class);
			ThemeService themeserv = context.getBean("servTheme",ThemeService.class);
			SessionService sessionserv = context.getBean("servSession",SessionService.class);
			
			forma.updateFormation(champAModif, modif , idform);
			
			
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
