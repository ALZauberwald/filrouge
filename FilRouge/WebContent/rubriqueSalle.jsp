<%@page import="com.lip6.entities.Salle"%>
<%@page import="com.lip6.services.SalleService"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styles.css">
<meta charset="ISO-8859-1">
<title>Admin gestion salles</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<br>
	<br>
	<br>
	<br>
	<form action="AddSalleServlet" method="post">
	    <table>
	    	 
	    	<tr>          
	             <h1>Ajouter une nouvelle salle</h1>
            </tr>
            <tr>
	            <td><i>Adresse</i> <input type="text" name="adresse">  </td></td>
	            <td><i>Nom Salle</i> <input type="text" name="nomSalle">  </td></td>
            </tr>
            <tr> 
            	<td><input type="submit" name="submit">  </td> 
            </tr>
    	</table>
  	</form>
  	<br>
  	<form action="SearchSalleServlet" method="post">
	    <table>
	    	
            <tr>
            <h1>Chercher une salle existante</h1>
            <td>
            	<SELECT name="idSalle" >
            	<h1>Voici la liste de toutes les salles deja renseignees</h1>
            	<%ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());%>
    			<%SalleService salleserv= context.getBean("servSalle",SalleService.class);%>
    			<%java.util.Set<Salle> sallesdisponibles = salleserv.recupSalle(); %>
    			<% for (Object salle:sallesdisponibles){ %>
                   </br><OPTION Value="<%=salle.toString().split("  |  ")[0]%>"><%= salle %>
                <% } %>
                </SELECT>
            </td>
            </tr>
            	<td><input type="submit" name="submit">  </td> 
            </tr>
    	</table>
  	</form>
  	<form action="RemoveSalleServlet" method="post">
	    <table>
            <tr>
            <h1>Supprimer une salle existante</h1>
            <td>
	            <SELECT name="idSalle" >
            	<h1>Voici la liste de toutes les salles deja renseignees</h1>
    			<% for (Object salle:sallesdisponibles){ %>
                   </br><OPTION Value="<%=salle.toString().split("  |  ")[0]%>"><%= salle %>
                <% } %>
                </SELECT>
            </td>
            </tr>
            <tr> 
            	<td><input type="submit" name="submit">  </td> 
            </tr>
    	</table>
  	</form>
  	<%@include file="footer.jsp" %>
</body>
</html>