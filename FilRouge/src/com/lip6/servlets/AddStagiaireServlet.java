package com.lip6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lip6.services.StagiaireService;

/**
 * Servlet implementation class AddStagiaireServlet
 */
@WebServlet("/AddStagiaireServlet")
public class AddStagiaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStagiaireServlet() {
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
		long idSession = Long.parseLong(request.getParameter("idSession"));
		String nomStagiaire =request.getParameter("nomStagiaire");
		String prenomStagiaire = request.getParameter("prenomStagiaire");
		String adresse = request.getParameter("adresse");
		String tel =request.getParameter("tel");
		String mail = request.getParameter("mail");
		
		StagiaireService stagiaire= new StagiaireService();
		stagiaire.addStagiaire(idSession,nomStagiaire,prenomStagiaire,adresse,tel,mail);
		//redirection 
		response.sendRedirect("index.html");
	}

}
