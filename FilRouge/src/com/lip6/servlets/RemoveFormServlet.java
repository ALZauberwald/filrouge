package com.lip6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lip6.services.FormationService;
import com.lip6.services.PrerequisService;

/**
 * Servlet implementation class RemoveSessionServlet
 */
@WebServlet("/RemoveFormServlet")
public class RemoveFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFormServlet() {
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
		System.out.println("j'arrive ici (RemoveFormServlet)");
		long id = Long.parseLong(request.getParameter("idFormation"));
		
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		FormationService formation = context.getBean("servFormation",FormationService.class);
		
		formation.removeFormation(id);
		//redirection 
		response.sendRedirect("accueilAdmin.jsp");
	}

}
