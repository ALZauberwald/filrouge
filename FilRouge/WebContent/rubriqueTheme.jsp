<%@page import="com.lip6.services.ThemeService"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Rubrique Theme</title>
</head>

<body>
<%@ include file="header.jsp" %>
	<br>
	<br>
	<br>
	<br>
	<h1>Ajouter un Theme</h1>
	<form action="AddThemeServlet" method="POST">
		<table>			
			<tr>          
		       	<td><i>Ajouter un Theme à la liste des Themes de la base de donnée.</i> 
	        </tr>
	        <tr>
	            <td><i>Veuillez renseigner le nom du Theme</i><input type="text" name="nomTheme"></td> 
	        </tr>            
	        <tr>
	           	<td><input type="submit" name="submit"></td>
	        </tr>
		</table>
	</form>
	
	
	<h1>Rechercher un theme déjà existant</h1>
	<br>
	<form action="SearchThemeServlet" method="POST">
		<table>		
			<tr>          
	          	<td><i>Rechercher un theme</i> 
	         </tr>
	         <tr>   
		         <Select name ="idTheme">
		         	<%ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());%>
    				<%ThemeService thmserv= context.getBean("servTheme",ThemeService.class);%>
					<%java.util.Set<com.lip6.entities.Theme> themesdisponibles = thmserv.recupTheme(); %>
					<% for (Object theme:themesdisponibles){ %>
	   				</br><option value ="<%= theme.toString().split("  |  ")[0]%>"><%= theme %> 
					<% } %>
				 </Select>     	
	         </tr>        
	         <tr>
	         	<td><input type="submit" name="submit"></td>
	         </tr>
		</table>
	</form>
	
	
	<h1>Supprimer un theme déjà existant</h1>
	<br>
	<form action="RemoveThemeServlet" method="POST">
		<table>		
			<tr>          
	         	<td><i>Supprimer un theme de la base de donnée.</i> 
	        </tr>
	        <tr>  
	        	<Select name ="idTheme">
					<% for (Object theme:themesdisponibles){ %>
	   				</br><option value ="<%= theme.toString().split("  |  ")[0]%>"><%= theme %> 
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