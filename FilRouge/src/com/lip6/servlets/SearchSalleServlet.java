package com.lip6.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lip6.services.SalleService;

/**
 * Servlet implementation class SearchSalleServlet
 */
@WebServlet("/SearchSalleServlet")
public class SearchSalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSalleServlet() {
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
		long id = Long.parseLong(request.getParameter("idSalle"));
		SalleService salle = new SalleService();
		salle.searchSalle(id);
		request.setAttribute("salle",salle.searchSalle(id));
		RequestDispatcher rd= request.getRequestDispatcher("infosalle.jsp") ;
		rd.forward(request, response);
	}

}
