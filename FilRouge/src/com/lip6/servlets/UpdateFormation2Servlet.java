package com.lip6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lip6.daos.DAOFormation;
import com.lip6.entities.Formation;
import com.lip6.entities.Salle;
import com.lip6.entities.Session;
import com.lip6.entities.TypeSession;
import com.lip6.services.FormationService;
import com.lip6.services.SessionService;

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
			if(choix.equals("asso")) {
				long idform= Long.parseLong(request.getParameter("idFormation"));
				long idObj= Long.parseLong(request.getParameter("idObjectif"));
				FormationService forma = new FormationService();
				forma.assoObjectif(idform, idObj);
			}
			else if (choix.equals("rm")) {
				long idform= Long.parseLong(request.getParameter("idFormationRm"));
				long idObj= Long.parseLong(request.getParameter("idObjectifRm"));
				FormationService formation = new FormationService();
				formation.rmObjectif(idform, idObj);
			}
			else if(choix.equals("assoPrerequis")) {
				long idform= Long.parseLong(request.getParameter("idFormation"));
				long idObj= Long.parseLong(request.getParameter("idPrerequis"));
				FormationService forma = new FormationService();
				forma.assoPrerequis(idform, idObj);
			}
			else if (choix.equals("rmPrerequis")) {
				long idform= Long.parseLong(request.getParameter("idFormationRm"));
				long idObj= Long.parseLong(request.getParameter("idPrerequisRm"));
				FormationService formation = new FormationService();
				formation.rmPrerequis(idform, idObj);
			}
			else if(choix.equals("assoChapitre")) {
				long idform= Long.parseLong(request.getParameter("idFormation"));
				long idChap= Long.parseLong(request.getParameter("idChapitre"));
				FormationService forma = new FormationService();
				forma.assoChapitre(idform, idChap);
			}
			else if (choix.equals("rmChapitre")) {
				long idform= Long.parseLong(request.getParameter("idFormationRm"));
				long idObj= Long.parseLong(request.getParameter("idChapitreRm"));
				FormationService formation = new FormationService();
				formation.rmChapitre(idform, idObj);
			}

			response.sendRedirect("index.html");
	}

}
