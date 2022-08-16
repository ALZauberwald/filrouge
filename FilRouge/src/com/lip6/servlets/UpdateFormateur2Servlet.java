package com.lip6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lip6.entities.Formateur;
import com.lip6.services.FormateurService;

/**
 * Servlet implementation class UpdateFormateur2Servlet
 */
@WebServlet("/UpdateFormateur2Servlet")
public class UpdateFormateur2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFormateur2Servlet() {
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
		if(choix.equals("assoSession")) {
			long idFormateur= Long.parseLong(request.getParameter("idFormateur"));
			long idSess= Long.parseLong(request.getParameter("idSession"));
			FormateurService formateur = new FormateurService();
			formateur.assoSession(idFormateur,idSess );
		}
		else if (choix.equals("rmSession")) {
			long idFormateur= Long.parseLong(request.getParameter("idFormateurRm"));
			long idSess= Long.parseLong(request.getParameter("idSessRm"));
			FormateurService formateur = new FormateurService();
			formateur.removeSession(idFormateur,idSess );
		}
		response.sendRedirect("index.html");
	}

}
