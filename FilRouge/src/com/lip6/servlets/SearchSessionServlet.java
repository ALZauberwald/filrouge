package com.lip6.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lip6.entities.Session;
import com.lip6.services.ClientService;
import com.lip6.services.FormateurService;
import com.lip6.services.FormationService;
import com.lip6.services.SalleService;
import com.lip6.services.SessionService;
import com.lip6.services.StagiaireService;

/**
 * Servlet implementation class SearchSessionServlet
 */
@WebServlet("/SearchSessionServlet")
public class SearchSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSessionServlet() {
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
		long id = Long.parseLong(request.getParameter("idSession"));
		SessionService session= new SessionService();
		SalleService salleserv = new SalleService();
		FormationService formserv = new FormationService();
		FormateurService formateurserv = new FormateurService();
		ClientService cliserv = new ClientService();
		StagiaireService stagserv = new StagiaireService();

		request.setAttribute("sess",session.searchSession(id));
		request.setAttribute("sallesdisponibles",salleserv.recupSalle());
		request.setAttribute("formationsdisponibles",formserv.recupFormations());
		request.setAttribute("formateursdisponibles",formateurserv.recupFormateur());
		request.setAttribute("clientsdisponibles",cliserv.recupClient());
		request.setAttribute("stagiairesdisponibles",stagserv.recupStagiaire());
		
		RequestDispatcher rd= request.getRequestDispatcher("infosession.jsp") ;
		rd.forward(request, response);
		
	}
	

}
