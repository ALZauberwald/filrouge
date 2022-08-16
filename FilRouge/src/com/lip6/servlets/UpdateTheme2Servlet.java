package com.lip6.servlets;

import java.io.IOException;
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
import com.lip6.services.FormationService;
import com.lip6.services.PrerequisService;
import com.lip6.services.SessionService;
import com.lip6.services.ThemeService;

/**
 * Servlet implementation class UpdateSessionServlet
 */
@WebServlet("/UpdateTheme2Servlet")
public class UpdateTheme2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTheme2Servlet() {
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
			String choix = request.getParameter("choix");
			
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			ThemeService them = context.getBean("servTheme",ThemeService.class);
			
			if(choix.equals("assoFormation")) {
				long idTheme= Long.parseLong(request.getParameter("idTheme"));
				long idForm= Long.parseLong(request.getParameter("idFormation"));
				them.assoFormation(idTheme, idForm);
			}
			else if (choix.equals("rmFormation")) {
				long idTheme= Long.parseLong(request.getParameter("idThemeRm"));
				long idForm= Long.parseLong(request.getParameter("idFormationRm"));
				them.rmFormation(idTheme, idForm);
			}
			else if(choix.equals("assoSoustheme")) {
				long idTheme= Long.parseLong(request.getParameter("idTheme"));
				long idSoustheme= Long.parseLong(request.getParameter("idSoustheme"));
				them.assoSoustheme(idTheme, idSoustheme);
			}
			else if (choix.equals("rmSoustheme")) {
				long idTheme= Long.parseLong(request.getParameter("idThemeRm"));
				long idSoustheme= Long.parseLong(request.getParameter("idSousthemeRm"));
				them.rmSoustheme(idTheme, idSoustheme);
			}
			
			response.sendRedirect("index.html");
	}

}
