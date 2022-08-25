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

import com.lip6.daos.DAOFormation;
import com.lip6.entities.Formation;
import com.lip6.entities.Salle;
import com.lip6.entities.Session;
import com.lip6.entities.TypeSession;
import com.lip6.services.ClientService;
import com.lip6.services.FormateurService;
import com.lip6.services.FormationService;
import com.lip6.services.SalleService;
import com.lip6.services.SessionService;
import com.lip6.services.StagiaireService;

/**
 * Servlet implementation class UpdateSessionServlet
 */
@WebServlet("/UpdateSessionServlet")
public class UpdateSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSessionServlet() {
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
        FormationService formserv = context.getBean("servFormation",FormationService.class);
        
		String champAModif = request.getParameter("champAModif");
		String modif = request.getParameter("modif");
		String idstr = request.getParameter("idSession");
		long id = Long.parseLong(idstr);
		session.updateSession(champAModif, modif , id);
		
		
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
