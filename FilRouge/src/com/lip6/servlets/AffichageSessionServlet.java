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

/**
 * Servlet implementation class AffichageSessionServlet
 */
@WebServlet("/AffichageSessionServlet")
public class AffichageSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffichageSessionServlet() {
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
		System.out.println(request.getParameter("idSession"));
		Long idSession = Long.parseLong(request.getParameter("idSession"));
		SessionService sessionserv = context.getBean("servSession",SessionService.class);
		request.setAttribute("sess",sessionserv.searchSession(idSession) );
		RequestDispatcher rd= request.getRequestDispatcher("affichageSession.jsp") ;
		rd.forward(request, response);
	}

}
