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
 * Servlet implementation class InscriptionStagiaireServlet
 */
@WebServlet("/InscriptionStagiaireServlet")
public class InscriptionStagiaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionStagiaireServlet() {
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
        
		long idSession = Long.parseLong(request.getParameter("idSession"));
		String nomStagiaire =request.getParameter("nomStagiaire");
		String prenomStagiaire = request.getParameter("prenomStagiaire");
		String adresse = request.getParameter("adresse");
		String tel =request.getParameter("tel");
		String mail = request.getParameter("mail");
		
		System.out.println(request.getParameter("idSession"));
		SessionService sessionserv = context.getBean("servSession",SessionService.class);
		request.setAttribute("sess",sessionserv.searchSession(idSession) );
		stagiaire.addStagiaire(idSession,nomStagiaire,prenomStagiaire,adresse,tel,mail);
		RequestDispatcher rd= request.getRequestDispatcher("confirmationinscription.jsp") ;
		rd.forward(request, response);
	}

}
