<%@page import="com.lip6.entities.Prerequis"%>
<%@page import="com.lip6.services.PrerequisService"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Rubrique Prerequis</title>
</head>

<body>
	<h1>Ajouter un Prerequis</h1>
	<form action="AddPrerequisServlet" method="POST">
		<table>			
			<tr>          
		       	<td><i>Ajouter un Prerequis � la liste des Prerequis de la base de donn�e.</i> 
	        </tr>
	        <tr>
	            <td><i>Veuillez renseigner le nom du Prerequis</i><input type="text" name="nomPrerequis"></td> 
	        </tr>            
	        <tr>
	           	<td><input type="submit" name="submit"></td>
	        </tr>
		</table>
	</form>
	
	
	<h1>Rechercher un Prerequis d�j� existant</h1>
	<br>
	<form action="SearchPrerequisServlet" method="POST">
		<table>		
			<tr>          
	          	<td><i>Rechercher un Prerequis</i> 
	         </tr>
	         <tr> 
	         	<Select name ="idPrerequis">
		            <%ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());%>
    				<%PrerequisService prerequisserv= context.getBean("servPrerequis",PrerequisService.class);%>
					<%java.util.Set<Prerequis> prerequisdisponibles = prerequisserv.recupPrerequis(); %>
					<% for (Object prerequis:prerequisdisponibles){ %>
	   				</br><option value ="<%= prerequis.toString().split("  |  ")[0]%>"><%= prerequis %> 
					<% } %>
				 </Select>     	       	
	         </tr>        
	         <tr>
	         	<td><input type="submit" name="submit"></td>
	         </tr>
		</table>
	</form>
	
	
	<h1>Supprimer un Prerequis d�j� existant</h1>
	<br>
	<form action="RemovePrerequisServlet" method="POST">
		<table>		
			<tr>          
	         	<td><i>Supprimer un Prerequis de la base de donn�e.</i> 
	        </tr>
	        <tr> 
	        	<Select name ="idPrerequis">
					<% for (Object prerequis:prerequisdisponibles){ %>
	   				</br><option value ="<%= prerequis.toString().split("  |  ")[0]%>"><%= prerequis %> 
					<% } %>
				</Select>     	      
	        <tr>
	            <td><input type="submit" name="submit"></td>
	        </tr>
		</table>
	</form>
</body>
</html>