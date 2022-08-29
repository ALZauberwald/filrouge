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
import com.lip6.services.ObjectifService;
import com.lip6.services.PrerequisService;
import com.lip6.services.ThemeService;


/**
 * Servlet implementation class UpdateSessionServlet
 */
@WebServlet("/UpdateThemeServlet")
public class UpdateThemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateThemeServlet() {
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
			
			String champAModif = request.getParameter("champAModif");
			String modif = request.getParameter("modif");
			String idstr = request.getParameter("idTheme");
			long id = Long.parseLong(idstr);
			
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			ThemeService thserv = context.getBean("servTheme",ThemeService.class);
			

			thserv.updateTheme(champAModif, modif , id);
			FormationService formationserv = context.getBean("servFormation",FormationService.class);
			request.setAttribute("formationsdisponibles", formationserv.recupFormations());
			
			
			request.setAttribute("themesdisponibles", thserv.recupTheme());
			
			request.setAttribute("form",thserv.searchTheme(id));
			RequestDispatcher rd= request.getRequestDispatcher("infoTheme.jsp") ;
			rd.forward(request, response);
	}

}
