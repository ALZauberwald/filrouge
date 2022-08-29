<%@page import="com.lip6.entities.Objectif"%>
<%@page import="com.lip6.services.ObjectifService"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/styles.css">
	<title>Rubrique objectif</title>
</head>

<body>
<%@ include file="header.jsp" %>
	<br>
	<br>
	<br>
	<br>
	<h1>Ajouter un objectif</h1>
	<form action="AddObjectifServlet" method="POST">
		<table>			
			<tr>          
		       	<td><i>Ajouter un objectif à la liste des objectifs de la base de donnée.</i> 
	        </tr>
	        <tr>
	            <td><i>Veuillez renseigner le nom de l'objectif</i><input type="text" name="nomObjectif"></td> 
	        </tr>            
	        <tr>
	           	<td><input type="submit" name="submit"></td>
	        </tr>
		</table>
	</form>
	
	
	<h1>Rechercher un objectif déjà existant</h1>
	<br>
	<form action="SearchObjectifServlet" method="POST">
		<table>		
			<tr>          
	          	<td><i>Rechercher un objectif</i> 
	         </tr>
	         <tr>   
	         	<Select name ="idObjectif">
		         	<%ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());%>
	    			<%ObjectifService objectifserv= context.getBean("servObjectif",ObjectifService.class);%>
					<%java.util.Set<Objectif> objectifsdisponibles = objectifserv.recupObjectifs(); %>
					<% for (Object objectif:objectifsdisponibles){ %>
	   				</br><option value ="<%= objectif.toString().split("  |  ")[0]%>"><%= objectif %> 
					<% } %>
				 </Select>               	
	         </tr>        
	         <tr>
	         	<td><input type="submit" name="submit"></td>
	         </tr>
		</table>
	</form>
	
	
	<h1>Supprimer un objectif déjà existant</h1>
	<br>
	<form action="RemoveObjectifServlet" method="POST">
		<table>		
			<tr>          
	         	<td><i>Supprimer un objectif de la base de donnée.</i> 
	        </tr>
	        <tr>  
	        	<Select name ="idObjectif">
					<% for (Object objectif:objectifsdisponibles){ %>
	   				</br><option value ="<%= objectif.toString().split("  |  ")[0]%>"><%= objectif %> 
					<% } %>
				</Select>   	       
	        <tr>
	            <td><input type="submit" name="submit"></td>
	        </tr>
		</table>
	</form>
	<%@include file="footer.jsp" %>
</body>
</html>