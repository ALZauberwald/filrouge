<%@page import="com.lip6.entities.Stagiaire"%>
<%@page import="com.lip6.services.StagiaireService"%>
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
	<form action="AddStagiaireServlet" method="POST">
		<table>
			
			<tr>          
	            <td><i>Ajouter une session à la base de donnée.</i> 
            </tr>
            <tr>
            	<td><i>Id de la session</i><input type="number" name="idSession"></td> 
            	<td><i>Veuillez rentrer votre nom</i> <input type="text" name="nomStagiaire">  </td>
	            <td><i>Veuillez rentrer votre prénom</i> <input type="text" name="prenomStagiaire">  </td>
	            <td><i>Veuillez rentrer votre adresse</i> <input type="text" name="adresse">  </td>
	            <td><i>Veuillez rentrer votre numéro de téléphone</i> <input type="text" name="tel">  </td>
	            <td><i>Veuillez rentrer votre mail</i> <input type="text" name="mail">  </td>
            </tr>
            
            <tr>
            <td><input type="submit" name="submit"></td>
            </tr>
		</table>
	</form>
	<br>
	<form action="SearchStagiaireServlet" method="POST">
		<table>		
			<tr>          
	          	<td><i>Rechercher un Stagiaire</i> </td>
	        <h1>Voici la liste de tous les stagiaires deja renseignes</h1>
	        
            	<SELECT name="idStagiaire" >
            	<%ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());%>
    			<%StagiaireService stagiaireserv= context.getBean("servStagiaire",StagiaireService.class);%>
    			<%java.util.Set<Stagiaire> stagiairesdisponibles = stagiaireserv.recupStagiaire(); %>
    			<% for (Object stag:stagiairesdisponibles){ %>
                   </br><OPTION Value="<%=stag.toString().split("  |  ")[0]%>"><%= stag %>
                <% } %>
                </SELECT>
            </tr>
            <tr>
	         	<td><input type="submit" name="submit"></td>
	         </tr>
		</table>
	</form>
	<br>
	<form action="RemoveStagiaireServlet" method="POST">
		<table>		
			<tr>          
	          	<td><i>Remove un Stagiaire</i></td>
	        	
            	<h1>Voici la liste de tous les stagiaires deja renseignes</h1>
	        	<SELECT name="idStagiaire" >
    			<% for (Object stag:stagiairesdisponibles){ %>
                   </br><OPTION Value="<%=stag.toString().split("  |  ")[0]%>"><%= stag %>
                <% } %>
                </SELECT>
      		</tr>
	         <tr>
	         	<td><input type="submit" name="submit"></td>
	         </tr>
		</table>
	</form>
</body>
</html>