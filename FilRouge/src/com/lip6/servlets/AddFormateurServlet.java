package com.lip6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lip6.services.FormateurService;

/**
 * Servlet implementation class AddFormateurServlet
 */
@WebServlet("/AddFormateurServlet")
public class AddFormateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFormateurServlet() {
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
		String nom =request.getParameter("nomFormateur");
		String prenom = request.getParameter("prenomFormateur");
		String adresse = request.getParameter("adresse");
		String tel =request.getParameter("tel");
		String mail = request.getParameter("mail");
		String dateEmbauche=request.getParameter("dateEmbauche");
		FormateurService fs = new FormateurService();
		fs.addFormateur(nom, prenom,  adresse,tel, mail,dateEmbauche);
		response.sendRedirect("index.html");
	}

}
