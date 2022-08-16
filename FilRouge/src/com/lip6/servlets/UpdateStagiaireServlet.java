package com.lip6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lip6.services.StagiaireService;

/**
 * Servlet implementation class UpdateStagiaireServlet
 */
@WebServlet("/UpdateStagiaireServlet")
public class UpdateStagiaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStagiaireServlet() {
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
		long idStagiaire = Long.parseLong(request.getParameter("idStagiaire"));
		String champAModif = request.getParameter("champAModif");
		String modif = request.getParameter("modif");
		
		StagiaireService ss = new StagiaireService();
		ss.updateStagiaire(idStagiaire,champAModif,modif);
		response.sendRedirect("index.html");
	}

}
