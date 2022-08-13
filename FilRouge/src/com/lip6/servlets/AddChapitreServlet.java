package com.lip6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lip6.services.FormationService;
import com.lip6.services.ChapitreService;

/**
 * Servlet implementation class AddFormServlet
 */
@WebServlet("/AddChapitreServlet")
public class AddChapitreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddChapitreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String nomchap =request.getParameter("nomChapitre");
		int dureechap =Integer.parseInt(request.getParameter("dureeChapitre"));
		String detailchap =request.getParameter("detailChapitre");
		
		ChapitreService Chapitre= new ChapitreService();
		Chapitre.createChapitre(nomchap, dureechap, detailchap);
		//redirection 
		response.sendRedirect("index.html");
	}

}
