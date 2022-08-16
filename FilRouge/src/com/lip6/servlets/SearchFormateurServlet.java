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

import com.lip6.services.FormateurService;
import com.lip6.services.SessionService;

/**
 * Servlet implementation class SearchFormateurServlet
 */
@WebServlet("/SearchFormateurServlet")
public class SearchFormateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFormateurServlet() {
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
        FormateurService fs = context.getBean("servFormateur",FormateurService.class);
        SessionService session = context.getBean("servSession",SessionService.class);
        
		long idFormateur = Long.parseLong(request.getParameter("idFormateur"));
		
		request.setAttribute("form",fs.searchFormateur(idFormateur));
		request.setAttribute("sessionsdisponibles",session.recupSession());
		
		RequestDispatcher rd= request.getRequestDispatcher("infoformateur.jsp") ;
		rd.forward(request, response);
	}

}
