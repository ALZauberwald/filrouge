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

import com.lip6.services.ClientService;
import com.lip6.services.SessionService;

/**
 * Servlet implementation class UpdateClientServlet
 */
@WebServlet("/UpdateClientServlet")
public class UpdateClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClientServlet() {
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
        ClientService cs = context.getBean("servClient",ClientService.class);
        SessionService session = context.getBean("servSession",SessionService.class);
        
		long idClient = Long.parseLong(request.getParameter("idClient"));
		String champAModif = request.getParameter("champAModif");
		String modif = request.getParameter("modif");
		
		cs.updateClient(idClient,champAModif,modif);
		request.setAttribute("cli",cs.searchClient(idClient));
		request.setAttribute("sessionsdisponibles",session.recupSession());
		
		RequestDispatcher rd= request.getRequestDispatcher("infoclient.jsp") ;
		rd.forward(request, response);
	}

}
