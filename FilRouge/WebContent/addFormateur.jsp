<%@page import="com.lip6.entities.Formateur"%>
<%@page import="com.lip6.services.FormateurService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddFormateurServlet" method="POST">
		<table>
			
			<tr>          
	            <td><i>Ajouter une session à la base de donnée.</i> 
            </tr>
            <tr> 
            	<td><i>Veuillez rentrer le nom</i> <input type="text" name="nomFormateur">  </td>
	            <td><i>Veuillez rentrer le prénom</i> <input type="text" name="prenomFormateur">  </td>
	            <td><i>Veuillez rentrer l'adresse</i> <input type="text" name="adresse">  </td>
	            <td><i>Veuillez rentrer le numéro de téléphone</i> <input type="text" name="tel">  </td>
	            <td><i>Veuillez rentrer le mail</i> <input type="text" name="mail">  </td>
	            <td><i>Veuillez rentrer la date d'embauche</i> <input type="text" name="dateEmbauche">  </td>
	            
            </tr>
            
            <tr>
            <td><input type="submit" name="submit"></td>
            </tr>
		</table>
	</form>
	<br>
	<h1>Rechercher un formateur existant</h1>
	<br>
	<form action="SearchFormateurServlet" method="POST">
		<table>		
			<tr>          
	          	<td><i>Rechercher un formateur</i> 
	         </tr>
	         <tr>
            	<SELECT name="idFormateur" >
            	<h1>Voici la liste de touts formateurs déjà renseignés</h1>
    		<%FormateurService formserv= new FormateurService();%>
    		<%java.util.Set<Formateur> formateurdisponibles = formserv.recupFormateur(); %>
    		<% for (Object form:formateurdisponibles){ %>
                   </br><OPTION Value="<%=form.toString().split("  |  ")[0]%>"><%= form %>
                <% } %>
                </SELECT>
            </tr>      
	         <tr>
	         	<td><input type="submit" name="submit"></td>
	         </tr>
		</table>
	</form>
	<br>
	<h1>Supprimer un formateur existant</h1>
	<br>
	<form action="RemoveFormateurServlet" method="POST">
		<table>		
			<tr>          
	          	<td><i>Supprimer un formateur</i> 
	         </tr>
<tr>
            	<SELECT name="idFormateur" >
            	<h1>Voici la liste de touts formateurs déjà renseignés</h1>
    			<% for (Object form:formateurdisponibles){ %>
                   </br><OPTION Value="<%=form.toString().split("  |  ")[0]%>"><%= form %>
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