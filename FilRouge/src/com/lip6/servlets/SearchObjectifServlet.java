package com.lip6.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lip6.services.ObjectifService;
import com.lip6.services.PrerequisService;

/**
 * Servlet implementation class SearchSessionServlet
 */
@WebServlet("/SearchObjectifServlet")
public class SearchObjectifServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchObjectifServlet() {
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
		long id = Long.parseLong(request.getParameter("idObjectif"));
		
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ObjectifService objectif = context.getBean("servObjectif",ObjectifService.class);
		
		request.setAttribute("form",objectif.searchObjectif(id));
		RequestDispatcher rd= request.getRequestDispatcher("infoobjectif.jsp") ;
		rd.forward(request, response);
	
		
	}
	

}
