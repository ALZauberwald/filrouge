package com.lip6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lip6.services.FormationService;
import com.lip6.services.SalleService;

/**
 * Servlet implementation class UpdateSalle2Servlet
 */
@WebServlet("/UpdateSalle2Servlet")
public class UpdateSalle2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSalle2Servlet() {
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
			long idsalle= Long.parseLong(request.getParameter("idSalle"));
			long idsess= Long.parseLong(request.getParameter("idSession"));
			SalleService sa = new SalleService();
			sa.assoSession(idsalle, idsess);
		}
		else if (choix.equals("rmSession")) {
			long idsalle= Long.parseLong(request.getParameter("idSalleRm"));
			long idsess= Long.parseLong(request.getParameter("idSessionRm"));
			SalleService salle = new SalleService();
			salle.removeSession(idsalle, idsess);
		}
		response.sendRedirect("index.html");
	}

}