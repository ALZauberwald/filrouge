package com.lip6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lip6.entities.TypeSession;
import com.lip6.services.SalleService;
import com.lip6.services.SessionService;

/**
 * Servlet implementation class CreerSession
 */
@WebServlet("/AddSessionServlet")
public class AddSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSessionServlet() {
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
		
		
		long formation = Long.parseLong(request.getParameter("idFormation"));
		String nomSession =request.getParameter("nomSession");
		String prixSession =request.getParameter("prix");
		String dateDebut = request.getParameter("dateDebut");
		String dateFin = request.getParameter("dateFin");
		String lieuSession =request.getParameter("lieuSession");
		String typeSession = request.getParameter("typeSession");
		
		TypeSession type = TypeSession.INTER_ENTREPRISE;
		if(typeSession.equals("inter entreprise"))
			type= TypeSession.INTER_ENTREPRISE;
		else if(typeSession.equals("intra entreprise"))
			type= TypeSession.INTRA_ENTREPRISE;
		else if(typeSession.equals("perso"))
			type= TypeSession.PERSONNALISEE;
		
		
		
		session.createSession(formation,nomSession,Float.parseFloat(prixSession),dateDebut,dateFin,lieuSession,type);
		//redirection 
		response.sendRedirect("rubriqueSession.jsp");
	}

}
