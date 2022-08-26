<%@page import="com.lip6.entities.Formation"%>
<%@page import="com.lip6.services.FormationService"%>
<%@page import="com.lip6.entities.Session"%>
<%@page import="com.lip6.services.SessionService"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styles.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<br>
	<br>
	<br>
	<br>

<form action="AddSessionServlet" method="POST">
	<table class="table "id ="afftbl"><caption class="caption-top aligncenter">Ajouter une nouvelle session<br></caption>
			 
			<tr class="table-info">          
	            <td id ="afftd">Veuillez choisir la formation</td> 
            	<td id ="afftd">Veuillez rentrer le nom de la session</td>
	            <td id ="afftd">Prix de la session</td>
	            <td id ="afftd">Date de début de la session</td>
	            <td id ="afftd">Date de fin de la session</td>
	            <td id ="afftd">Ville de la session</td>
	            <td id ="afftd">Type de session</td>
	            <td id ="afftd">Ajouter</td>
            </tr>
            <tr>
            	<td id ="afftd">
	            	<Select name ="idFormation">
			            <%ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());%>
	    				<%FormationService formaserv= context.getBean("servFormation",FormationService.class);%>
						<%java.util.Set<Formation> formationsdisponibles = formaserv.recupFormations(); %>
						<% for (Object formation:formationsdisponibles){ %>
		   				</br><option value ="<%= formation.toString().split("  |  ")[0]%>"><%= formation %> 
						<% } %>
					</Select> 
				</td>
            	<td id ="afftd"><input type="text" name="nomSession"></td>
            	<td id ="afftd"><input type="text" name="prix"></td>
            	<td id ="afftd"><input type="text" name="dateDebut"></td>
            	<td id ="afftd"><input type="text" name="dateFin"></td>
            	<td id ="afftd"><input type="text" name="lieuSession"></td>
            	<td id ="afftd"><SELECT name="typeSession" size="1">
									<OPTION value="inter entreprise">Inter entreprise</OPTION>
									<OPTION value="intra entreprise">Intra entreprise</OPTION>
									<OPTION value="perso">Personnalisee</OPTION>
								</SELECT>
				</td>
            	<td id ="afftd"><input type="submit" name="submit" value="ajouter"></td>
            </tr>
            
	</table>
</form>
<br>
<div class="retreci">
	<form action="SearchSessionServlet" method="POST">
		<table class="table" id ="afftbl"><caption class="caption-top aligncenter">Rechercher une session</caption>
            <tr class="table-info">
            	<td id ="afftd">Id et Nom de la Session</td>
            	<td id ="afftd">Valider</td>
            </tr>
            <tr>
	            <td id ="afftd">
	            <SELECT name="idSession" >	
	            	
	    			<%SessionService sessionserv= context.getBean("servSession",SessionService.class);%>
	    			<%java.util.Set<Session> sessionsdisponibles = sessionserv.recupSession(); %>
	    			<% for (Object sess:sessionsdisponibles){ %>
	                   </br><OPTION Value="<%=sess.toString().split("  |  ")[0]%>"><%= sess %>
	                <% } %>
	            </SELECT>
	            </td>
	            <td id ="afftd"><input type="submit" name="submit" value="rechercher"></td>
            </tr>         
		</table>
	</form>
</div>
<br>
<div class="retreci">
	<form action="RemoveSessionServlet" method="POST">
		<table class="table" id ="afftbl"><caption class="caption-top aligncenter">Supprimer une session</caption>
	            
	            <tr class="table-info">
	            	<td id ="afftd">Id et Nom de la Session</td>
	            	<td id ="afftd">Rechercher</td>
	            	
	            </tr>
	            <tr>
	            	<td id ="afftd">
		            	<SELECT name="idSession" >
		            	
		    			<% for (Object sess:sessionsdisponibles){ %>
		                   </br><OPTION Value="<%=sess.toString().split("  |  ")[0]%>"><%= sess %>
		                <% } %>
		                </SELECT>
		            </td>
		            <td id ="afftd"><input type="submit" name="submit" value="supprimer"></td>
	            </tr>
		</table>
	</form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>