package com.lip6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lip6.daos.DAOFormation;
import com.lip6.entities.Formation;
import com.lip6.entities.Salle;
import com.lip6.entities.Session;
import com.lip6.entities.TypeSession;
import com.lip6.services.FormationService;

/**
 * Servlet implementation class UpdateSessionServlet
 */
@WebServlet("/UpdateSessionServlet")
public class UpdateSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSessionServlet() {
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
			
			long idSession = Long.parseLong(request.getParameter("idSession"));
			String nomSession =(request.getParameter("nomSession"));
			float prix =Float.parseFloat(request.getParameter("prix"));
			String date =(request.getParameter("dateDebut"));
			String lieu =(request.getParameter("lieuSession"));
			Boolean formateur =Boolean.parseBoolean(request.getParameter("formateur"));
			String typeSession =(request.getParameter("typeSession"));
			String adresse =(request.getParameter("adresse"));
			long idSalle =Long.parseLong(request.getParameter("idSalle"));
			String nomSalle =(request.getParameter("nomSalle"));
			Boolean install =Boolean.parseBoolean(request.getParameter("install"));
			long idForm =Long.parseLong(request.getParameter("idFormation"));
			String nomFormation =(request.getParameter("nomFormation"));
			String detailFormation =(request.getParameter("detailFormation"));
			TypeSession type = TypeSession.INTER_ENTREPRISE;
			if(typeSession.equals("inter entreprise"))
				type= TypeSession.INTER_ENTREPRISE;
			else if(typeSession.equals("intra entreprise"))
				type= TypeSession.INTRA_ENTREPRISE;
			else if(typeSession.equals("perso"))
				type= TypeSession.PERSONNALISEE;
			Session s = new Session(nomSession,prix,date,lieu,type);
			s.setFormateurConfirme(formateur);
			Salle sa = new Salle(adresse, nomSalle);
			sa.setIdSalle(idSalle);
			sa.setInstallationFinie(install);
			s.setSalle(sa);
			Formation f = new Formation(nomFormation,detailFormation);
			f.setIdFormation(idForm);
			s.setIdSession(idSession);
			FormationService formation = new FormationService();
			formation.updateSession(s, idSession);
			response.sendRedirect("index.html");
	}

}
