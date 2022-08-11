package com.lip6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lip6.services.SalleService;
import com.lip6.services.SessionService;

/**
 * Servlet implementation class UpdateSalleServlet
 */
@WebServlet("/UpdateSalleServlet")
public class UpdateSalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSalleServlet() {
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
		long idSalle = Long.parseLong(request.getParameter("idSalle"));
		String adresse = request.getParameter("adresse");
		String nomSalle = request.getParameter("nomSalle");

		SalleService salle = new SalleService();
		salle.updateSalle(idSalle, adresse , nomSalle);
		response.sendRedirect("index.html");
	}

}
