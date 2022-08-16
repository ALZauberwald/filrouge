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

import com.lip6.entities.Session;
import com.lip6.services.ClientService;
import com.lip6.services.FormateurService;
import com.lip6.services.FormationService;
import com.lip6.services.SalleService;
import com.lip6.services.SessionService;
import com.lip6.services.StagiaireService;

/**
 * Servlet implementation class SearchSessionServlet
 */
@WebServlet("/SearchSessionServlet")
public class SearchSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSessionServlet() {
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
        SessionService session = context.getBean("servSession",SessionService.class);
        ClientService cs = context.getBean("servClient",ClientService.class);
        FormateurService fs = context.getBean("servFormateur",FormateurService.class);
        SalleService salle = context.getBean("servSalle",SalleService.class);
        StagiaireService stagiaire = context.getBean("servStagiaire",StagiaireService.class);
        
		long id = Long.parseLong(request.getParameter("idSession"));
		FormationService formserv = new FormationService();
		
		request.setAttribute("sess",session.searchSession(id));
		request.setAttribute("sallesdisponibles",salle.recupSalle());
		request.setAttribute("formationsdisponibles",formserv.recupFormations());
		request.setAttribute("formateursdisponibles",fs.recupFormateur());
		request.setAttribute("clientsdisponibles",cs.recupClient());
		request.setAttribute("stagiairesdisponibles",stagiaire.recupStagiaire());
		
		RequestDispatcher rd= request.getRequestDispatcher("infosession.jsp") ;
		rd.forward(request, response);
		
	}
	

}
