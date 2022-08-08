package com.lip6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lip6.entities.TypeSession;
import com.lip6.services.FormationService;

/**
 * Servlet implementation class CreerSession
 */
@WebServlet("/CreerSessionServlet")
public class CreerSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerSessionServlet() {
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
		long formation = Long.parseLong(request.getParameter("formation"));
		String nomSession =request.getParameter("nomSession");
		String prixSession =request.getParameter("prix");
		String dateDebut = request.getParameter("dateDebut");
		String lieuSession =request.getParameter("lieuSession");
		String typeSession = request.getParameter("typeSession");
		String adresse = request.getParameter("adresse");
		String nomSalle = request.getParameter("nomSalle");
		
		TypeSession type = TypeSession.INTER_ENTREPRISE;
		if(typeSession.equals("inter entreprise"))
			type= TypeSession.INTER_ENTREPRISE;
		else if(typeSession.equals("intra entreprise"))
			type= TypeSession.INTRA_ENTREPRISE;
		else if(typeSession.equals("perso"))
			type= TypeSession.PERSONNALISEE;
		
		
		
		FormationService form= new FormationService();
		form.createSession(formation,nomSession,Float.parseFloat(prixSession),dateDebut,lieuSession,type,adresse,nomSalle);
		//redirection 
		response.sendRedirect("index.html");
	}

}
