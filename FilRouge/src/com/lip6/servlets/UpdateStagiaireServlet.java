package com.lip6.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lip6.services.SessionService;
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
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		String[] allBeanNames = context.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
            System.out.println(beanName + "******************");
        }
        StagiaireService stagiaire = context.getBean("servStagiaire",StagiaireService.class);
        SessionService session = context.getBean("servSession",SessionService.class);

		long idStagiaire = Long.parseLong(request.getParameter("idStagiaire"));
		String champAModif = request.getParameter("champAModif");
		String modif = request.getParameter("modif");
		
		stagiaire.updateStagiaire(idStagiaire,champAModif,modif);
		request.setAttribute("stag",stagiaire.searchStagiaire(idStagiaire));
		request.setAttribute("sessionsdisponibles",session.recupSession());
		
		RequestDispatcher rd= request.getRequestDispatcher("infostagiaire.jsp") ;
		rd.forward(request, response);
	}

}
