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
		if(choix.equals("assoSession")) {
			long idsess= Long.parseLong(request.getParameter("idSession"));
			long idsalle= Long.parseLong(request.getParameter("idSalle"));
			SessionService session = new SessionService();
			session.assoSalle(idsess, idsalle);
		}
		else if (choix.equals("rmSession")) {
			long idsess= Long.parseLong(request.getParameter("idSessRm"));
			long idsalle= Long.parseLong(request.getParameter("idSalleRm"));
			SessionService session = new SessionService();
			session.removeSalle(idsess,idsalle );
		}
		response.sendRedirect("index.html");
	}

}
