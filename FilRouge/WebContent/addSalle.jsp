<%@page import="com.lip6.entities.Salle"%>
<%@page import="com.lip6.services.SalleService"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin gestion salles</title>
</head>
<body>
	<form action="AddSalleServlet" method="post">
	    <table>
	    	<tr>
		    	<th>Partie admin</th>          
	            <td><i>Ajouter une salle dans la base de donn&#233e.</i> 
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
		    	<th>Partie admin</th>          
	            <td><i>Chercher une salle dans la base de donn&#233e.</i> 
            </tr>
            <tr>
            	<SELECT name="idSalle" >
            	<h1>Voici la liste de toutes les salles deja renseignees</h1>
            	<%ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());%>
    			<%SalleService salleserv= context.getBean("servSalle",SalleService.class);%>
    			<%java.util.Set<Salle> sallesdisponibles = salleserv.recupSalle(); %>
    			<% for (Object salle:sallesdisponibles){ %>
                   </br><OPTION Value="<%=salle.toString().split("  |  ")[0]%>"><%= salle %>
                <% } %>
                </SELECT>
            </tr>
            	<td><input type="submit" name="submit">  </td> 
            </tr>
    	</table>
  	</form>
  	<form action="RemoveSalleServlet" method="post">
	    <table>
	    	<tr>
		    	<th>Partie admin</th>          
	            <td><i>Supprimer une salle dans la base de donn&#233e.</i> 
            </tr>
            <tr>
	            <SELECT name="idSalle" >
            	<h1>Voici la liste de toutes les salles deja renseignees</h1>
    			<% for (Object salle:sallesdisponibles){ %>
                   </br><OPTION Value="<%=salle.toString().split("  |  ")[0]%>"><%= salle %>
                <% } %>
                </SELECT>
            </tr>
            <tr> 
            	<td><input type="submit" name="submit">  </td> 
            </tr>
    	</table>
  	</form>
</body>
</html>