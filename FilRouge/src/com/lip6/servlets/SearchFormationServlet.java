package com.lip6.servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lip6.entities.Objectif;
import com.lip6.entities.Session;
import com.lip6.services.ChapitreService;
import com.lip6.services.FormationService;
import com.lip6.services.ObjectifService;

import com.lip6.services.PrerequisService;
import com.lip6.services.SessionService;


/**
 * Servlet implementation class SearchSessionServlet
 */
@WebServlet("/SearchFormationServlet")
public class SearchFormationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFormationServlet() {
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
		long id = Long.parseLong(request.getParameter("idFormation"));
		
		FormationService formation= new FormationService();	
		ObjectifService objectifserv= new ObjectifService();
		PrerequisService prerequisserv = new PrerequisService();
		ChapitreService chapitreserv = new ChapitreService();
		SessionService sessionserv = new SessionService();
		
		ObjectifService objectifserv= new ObjectifService();
		request.setAttribute("form",formation.searchFormation(id));
		request.setAttribute("objectifsdisponibles", objectifserv.recupObjectifs());
		request.setAttribute("prerequisdisponibles", prerequisserv.recupPrerequis());
		request.setAttribute("chapitresdisponibles", chapitreserv.recupChapitres());
		//request.setAttribute("sessionsdisponibles", sessionserv.recupSession());

		
		RequestDispatcher rd= request.getRequestDispatcher("infoformation.jsp") ;
		rd.forward(request, response);
	
		
	}
	

}