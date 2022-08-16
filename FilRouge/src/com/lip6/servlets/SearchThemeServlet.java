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

import com.lip6.services.FormationService;
import com.lip6.services.PrerequisService;
import com.lip6.services.SessionService;
import com.lip6.services.ThemeService;

/**
 * Servlet implementation class SearchSessionServlet
 */
@WebServlet("/SearchThemeServlet")
public class SearchThemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchThemeServlet() {
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
		// TODO Auto-generated method stub
		long id = Long.parseLong(request.getParameter("idTheme"));
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ThemeService theme = context.getBean("servTheme",ThemeService.class);
		
		FormationService formationserv = context.getBean("servFormation",FormationService.class);
		request.setAttribute("formationsdisponibles", formationserv.recupFormations());
		
		ThemeService themeserv = context.getBean("servTheme",ThemeService.class);
		request.setAttribute("themesdisponibles", themeserv.recupTheme());
		
		request.setAttribute("form",theme.searchTheme(id));
		RequestDispatcher rd= request.getRequestDispatcher("infoTheme.jsp") ;
		rd.forward(request, response);
	
		
	}
	

}
