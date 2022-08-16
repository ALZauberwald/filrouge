<%@page import="com.lip6.entities.Formation"%>
<%@page import="com.lip6.services.FormationService"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Rubrique Formation</title>
</head>


<body>
	<%-- <h1>Voici la liste de toutes les formations deja renseignees</h1>
	<%FormationService formaserv= new FormationService();%>
	<%java.util.Set<Formation> formationsdisponibles = formaserv.recupFormations(); %>
	<% for (Object formation:formationsdisponibles){ %>
   				</br><%= formation %> 
				<% } %> --%>


	<h1>Ajouter une formation</h1>
	<form action="AddFormServlet" method="post">
	    <table>
	    	<tr>
		    	<th>Partie admin</th>          
	            <td><i>Ajouter une formation &#224 la base de donn&#233e.</i> 
            </tr>
            <tr>
	            <td><i>Nom de la formation</i> <input type="text" name="formationname">  </td>
	            <td><i>D&#233tail de la formation</i> <input type="text" name="formationdetail">  </td>
	            <td><i>Objectif de la formation</i> <input type="text" name="formationobjectif">  </td>
	            <td><i>Pr&#233requis de la formation</i> <input type="text" name="formationprerequis">  </td>
            </tr>
            <tr> 
            	<td><input type="submit" name="submit">  </td> 
            </tr>
    	</table>
  	</form>
  	
  	
  	
  	<h1>Chercher une formation ou/et la mettre Ã  jour</h1>
	<form action="SearchFormationServlet" method="post">
	    <table>
	    	<tr>
		    	<th>Partie admin</th>          
	            <td><i>chercher une formation dans la base de donnÃ©e.</i> 
            </tr>
            <tr>
            	<Select name ="idFormation">
		            <%ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());%>
    				<%FormationService formaserv= context.getBean("servFormation",FormationService.class);%>
					<%java.util.Set<Formation> formationsdisponibles = formaserv.recupFormations(); %>
					<% for (Object formation:formationsdisponibles){ %>
	   				</br><option value ="<%= formation.toString().split("  |  ")[0]%>"><%= formation %> 
					<% } %>
				</Select>
            </tr>
            <tr> 
            	<td><input type="submit" name="submit">  </td> 
            </tr>
    	</table>
  	</form>
  	
  	
  	
  	<h1>Supprimer une formation</h1>
	<form action="RemoveFormServlet" method="post">
	    <table>
	    	<tr>
		    	<th>Partie admin</th>          
	            <td><i>Supprimer une formation de la base de donnÃ©e.</i> 
            </tr>
            <tr>
            	<Select name ="idFormation">
		            <!-- <td><i>Id de la formation Ã  rechercher</i> <input type="number" name="idFormation">  </td> -->
					<% for (Object formation:formationsdisponibles){ %>
	   				</br><option value ="<%= formation.toString().split("  |  ")[0]%>"><%= formation %> 
					<% } %>
				</Select>
	        </tr>
            <tr> 
            	<td><input type="submit" name="submit">  </td> 
            </tr>
    	</table>
  	</form>
</body>
</html>