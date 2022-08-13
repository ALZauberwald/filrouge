package com.lip6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lip6.services.ClientService;

/**
 * Servlet implementation class AddClientServlet
 */
@WebServlet("/AddClientServlet")
public class AddClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClientServlet() {
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
		String nom =request.getParameter("nomClient");
		String prenom = request.getParameter("prenomClient");
		String adresse = request.getParameter("adresse");
		String tel =request.getParameter("tel");
		String mail = request.getParameter("mail");
		String numSiret=request.getParameter("numSiret");
		ClientService cs = new ClientService();
		cs.addClient(nom, prenom,  adresse,tel, mail,numSiret);
		response.sendRedirect("index.html");
	}

}
