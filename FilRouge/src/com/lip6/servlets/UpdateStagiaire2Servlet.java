package com.lip6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lip6.entities.Stagiaire;
import com.lip6.services.StagiaireService;

/**
 * Servlet implementation class UpdateStagiaire2Servlet
 */
@WebServlet("/UpdateStagiaire2Servlet")
public class UpdateStagiaire2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStagiaire2Servlet() {
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
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		String[] allBeanNames = context.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
            System.out.println(beanName + "******************");
        }
        StagiaireService stagiaire = context.getBean("servStagiaire",StagiaireService.class);
        
		String choix = request.getParameter("choix");
		if(choix.equals("assoSession")) {
			long idStagiaire= Long.parseLong(request.getParameter("idStagiaire"));
			long idSess= Long.parseLong(request.getParameter("idSession"));
			stagiaire.assoSession(idStagiaire,idSess );
		}
		else if (choix.equals("rmSession")) {
			long idStagiaire= Long.parseLong(request.getParameter("idStagiaireRm"));
			long idSess= Long.parseLong(request.getParameter("idSessRm"));
			stagiaire.removeSession(idStagiaire,idSess );
		}
		response.sendRedirect("index.html");
	}

}
