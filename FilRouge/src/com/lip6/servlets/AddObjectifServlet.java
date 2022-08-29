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
import com.lip6.services.ObjectifService;
import com.lip6.services.PrerequisService;

/**
 * Servlet implementation class AddFormServlet
 */
@WebServlet("/AddObjectifServlet")
public class AddObjectifServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddObjectifServlet() {
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
		String nomobj =request.getParameter("nomObjectif");
		
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ObjectifService objectif = context.getBean("servObjectif",ObjectifService.class);
		
		objectif.createObjectif(nomobj);
		//redirection 
		response.sendRedirect("rubriqueObjectif.jsp");
	}

}
