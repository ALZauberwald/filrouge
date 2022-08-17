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
<title>Insert title here</title>
</head>
<body>
<h1>Partie admin</h1>
<form action="AddSessionServlet" method="POST">
<table>
			
			<tr>          
	            <td><i>Ajouter une session à la base de donnée.</i> 
            </tr>
            <tr>
            	<td><i>Veuillez choisir la formation</i><input type="number" name="formation"></td> 
            	<td><i>Veuillez rentrer le nom de la session</i> <input type="text" name="nomSession">  </td>
	            <td><i>Prix de la session</i> <input type="text" name="prix">  </td>
	            <td><i>Date de début de la session</i> <input type="text" name="dateDebut">  </td>
	            <td><i>Date de fin de la session</i> <input type="text" name="dateFin">  </td>
	            <td><i>Ville de la session</i> <input type="text" name="lieuSession">  </td>
	            <td><i>Type de session</i> <input type="text" name="typeSession">  </td>
            </tr>
            
            <tr>
            <td><input type="submit" name="submit"></td>
            </tr>
</table>
</form>
<br>
<form action="SearchSessionServlet" method="POST">
<table>
			
			<tr>          
	            <td><i>Rechercher une session</i> 
            </tr>
            
            <tr>
            	<SELECT name="idSession" >
            	<h1>Voici la liste de toutes les sessions deja renseignees</h1>
            	<%ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());%>
    			<%SessionService sessionserv= context.getBean("servSession",SessionService.class);%>
    			<%java.util.Set<Session> sessionsdisponibles = sessionserv.recupSession(); %>
    			<% for (Object sess:sessionsdisponibles){ %>
                   </br><OPTION Value="<%=sess.toString().split("  |  ")[0]%>"><%= sess %>
                <% } %>
                </SELECT>
            </tr>
            
            <tr>
            <td><input type="submit" name="submit"></td>
            </tr>
</table>
</form>
<br>

<form action="RemoveSessionServlet" method="POST">
<table>
			
			<tr>          
	            <td><i>Supprimer une session de la base de donnée.</i> 
            </tr>
            <tr>
            	<SELECT name="idSession" >
            	<h1>Voici la liste de toutes les sessions deja renseignees</h1>
    			<% for (Object sess:sessionsdisponibles){ %>
                   </br><OPTION Value="<%=sess.toString().split("  |  ")[0]%>"><%= sess %>
                <% } %>
                </SELECT>
            </tr>
            <td><input type="submit" name="submit"></td>
            </tr>
</table>

</form>
</body>
</html>