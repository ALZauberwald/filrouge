package com.lip6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lip6.services.ChapitreService;
import com.lip6.services.PrerequisService;


/**
 * Servlet implementation class UpdateSessionServlet
 */
@WebServlet("/UpdateChapitreServlet")
public class UpdateChapitreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateChapitreServlet() {
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
			String idstr = request.getParameter("idChapitre");
			long id = Long.parseLong(idstr);
			
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			ChapitreService chapitre = context.getBean("servChapitre",ChapitreService.class);
			
			chapitre.updateChapitre(champAModif, modif , id);
			response.sendRedirect("accueilAdmin.jsp");
	}

}
