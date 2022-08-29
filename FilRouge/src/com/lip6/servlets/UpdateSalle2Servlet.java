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

import com.lip6.services.FormationService;
import com.lip6.services.SalleService;
import com.lip6.services.SessionService;

/**
 * Servlet implementation class UpdateSalle2Servlet
 */
@WebServlet("/UpdateSalle2Servlet")
public class UpdateSalle2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSalle2Servlet() {
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
        SalleService salle = context.getBean("servSalle",SalleService.class);
        SessionService sessionserv = context.getBean("servSession",SessionService.class);

		long idsalle= Long.parseLong(request.getParameter("idSalle"));

		
		String choix = request.getParameter("choix");
		if(choix.equals("assoSession")) {
			long idsess= Long.parseLong(request.getParameter("idSession"));
			salle.assoSession(idsalle, idsess);
		}
		else if (choix.equals("rmSession")) {
			long idsalle2= Long.parseLong(request.getParameter("idSalleRm"));
			long idsess= Long.parseLong(request.getParameter("idSessionRm"));
			salle.removeSession(idsalle2, idsess);
		}
		
		request.setAttribute("salle",salle.searchSalle(idsalle));
		request.setAttribute("sessionsdisponibles", sessionserv.recupSession());
		
		RequestDispatcher rd= request.getRequestDispatcher("infosalle.jsp") ;
		rd.forward(request, response);
	}

}
