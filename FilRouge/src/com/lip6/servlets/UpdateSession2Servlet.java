package com.lip6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lip6.services.SessionService;

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
		String choix = request.getParameter("choix");
		if(choix.equals("assoSalle")) {
			long idSess= Long.parseLong(request.getParameter("idSession"));
			long idsalle= Long.parseLong(request.getParameter("idSalle"));
			SessionService session = new SessionService();
			session.assoSalle(idSess, idsalle);
		}
		else if (choix.equals("rmSalle")) {
			long idSess= Long.parseLong(request.getParameter("idSessRm"));
			long idsalle= Long.parseLong(request.getParameter("idSalleRm"));
			SessionService session = new SessionService();
			session.removeSalle(idSess,idsalle );
		}
		else if(choix.equals("assoFormation")) {
			long idSess= Long.parseLong(request.getParameter("idSession"));
			long idFormation= Long.parseLong(request.getParameter("idFormation"));
			SessionService session = new SessionService();
			session.assoFormation(idSess, idFormation);
		}
		else if (choix.equals("rmFormation")) {
			long idSess= Long.parseLong(request.getParameter("idSessRm"));
			long idFormation= Long.parseLong(request.getParameter("idFormationRm"));
			SessionService session = new SessionService();
			session.removeFormation(idSess,idFormation );
		}
		else if(choix.equals("assoFormateur")) {
			long idSess= Long.parseLong(request.getParameter("idSession"));
			long idFormateur= Long.parseLong(request.getParameter("idFormateur"));
			SessionService session = new SessionService();
			session.assoFormateur(idSess, idFormateur);
		}
		else if (choix.equals("rmFormateur")) {
			long idSess= Long.parseLong(request.getParameter("idSessRm"));
			long idFormateur= Long.parseLong(request.getParameter("idFormateurRm"));
			SessionService session = new SessionService();
			session.removeFormateur(idSess,idFormateur );
		}
		else if(choix.equals("assoStagiaire")) {
			long idSess= Long.parseLong(request.getParameter("idSession"));
			long idStagiaire= Long.parseLong(request.getParameter("idStagiaire"));
			SessionService session = new SessionService();
			session.assoStagiaire(idSess, idStagiaire);
		}
		else if (choix.equals("rmStagiaire")) {
			long idSess= Long.parseLong(request.getParameter("idSessRm"));
			long idStagiaire= Long.parseLong(request.getParameter("idStagiaireRm"));
			SessionService session = new SessionService();
			session.removeStagiaire(idSess,idStagiaire );
		}
		else if(choix.equals("assoClient")) {
			long idSess= Long.parseLong(request.getParameter("idSession"));
			long idClient= Long.parseLong(request.getParameter("idClient"));
			SessionService session = new SessionService();
			session.assoClient(idSess, idClient);
		}
		else if (choix.equals("rmClient")) {
			long idSess= Long.parseLong(request.getParameter("idSessRm"));
			long idClient= Long.parseLong(request.getParameter("idClientRm"));
			SessionService session = new SessionService();
			session.removeClient(idSess,idClient );
		}
		response.sendRedirect("index.html");
	}

}
