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
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<br>
	<br>
	<br>
	<br>
<form action="AddSessionServlet" method="POST">
<table>
			
			<tr>          
	            <h1>Ajouter une nouvelle session </h1>
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
	            <h1>Rechercher une session existante</h1>
            </tr>
            
            <tr>
            <td>
            	<SELECT name="idSession" >
            	
            	<%ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());%>
    			<%SessionService sessionserv= context.getBean("servSession",SessionService.class);%>
    			<%java.util.Set<Session> sessionsdisponibles = sessionserv.recupSession(); %>
    			<% for (Object sess:sessionsdisponibles){ %>
                   </br><OPTION Value="<%=sess.toString().split("  |  ")[0]%>"><%= sess %>
                <% } %>
                </SELECT>
            </td>
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
	            <h1>Supprimer une session existante</h1>
            </tr>
            <tr>
            <td>
            	<SELECT name="idSession" >
            	
    			<% for (Object sess:sessionsdisponibles){ %>
                   </br><OPTION Value="<%=sess.toString().split("  |  ")[0]%>"><%= sess %>
                <% } %>
                </SELECT>
            </td>
            </tr>
            <td><input type="submit" name="submit"></td>
            </tr>
	</table>
</form>
<%@include file="footer.jsp" %>
</body>
</html>