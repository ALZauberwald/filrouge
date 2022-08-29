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
import com.lip6.services.PrerequisService;
import com.lip6.services.SessionService;
import com.lip6.services.ThemeService;

/**
 * Servlet implementation class UpdateSessionServlet
 */
@WebServlet("/UpdateChapitre2Servlet")
public class UpdateChapitre2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateChapitre2Servlet() {
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
		ChapitreService cpserv = context.getBean("servChapitre",ChapitreService.class);
		
		long idChapitre= Long.parseLong(request.getParameter("idChapitre"));
		if(choix.equals("assoFormation")) {
			long idForm= Long.parseLong(request.getParameter("idFormation"));
			cpserv.assoFormation(idChapitre, idForm);
		}
		else if (choix.equals("rmFormation")) {
			long idChapitre2= Long.parseLong(request.getParameter("idChapitreRm"));
			long idForm= Long.parseLong(request.getParameter("idFormationRm"));
			cpserv.rmFormation(idChapitre2, idForm);
		}
		
		request.setAttribute("form",cpserv.searchChapitre(idChapitre));
		RequestDispatcher rd= request.getRequestDispatcher("infoChapitre.jsp") ;
		
		FormationService formationserv = context.getBean("servFormation",FormationService.class);
		request.setAttribute("formationsdisponibles", formationserv.recupFormations());
		
		
		rd.forward(request, response);
}

}
