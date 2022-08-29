<%@page import="com.lip6.entities.Formateur"%>
<%@page import="com.lip6.services.FormateurService"%>
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
	<form action="AddFormateurServlet" method="POST">
		<table>
			
			<tr>          
	            <h1>Ajouter un nouveau formateur</h1> 
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
	<br>
	<form action="SearchFormateurServlet" method="POST">
		<table>		
			<tr>          
	          	<h1>Chercher un formateur existant</h1> 
	         </tr>
	         <tr>
	         <td>
            	<SELECT name="idFormateur" >
            	
            	<%ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());%>
    			<%FormateurService formserv= context.getBean("servFormateur",FormateurService.class);%>
    			<%java.util.Set<Formateur> formateurdisponibles = formserv.recupFormateur(); %>
    			<% for (Object form:formateurdisponibles){ %>
                   </br><OPTION Value="<%=form.toString().split("  |  ")[0]%>"><%= form %>
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
	<br>
	<form action="RemoveFormateurServlet" method="POST">
		<table>		
			<tr>          
	          	<h1>Supprimer un formateur existant</h1>
	         </tr>
			<tr>
			<td>
            	<SELECT name="idFormateur" >
            	
    			<% for (Object form:formateurdisponibles){ %>
                   </br><OPTION Value="<%=form.toString().split("  |  ")[0]%>"><%= form %>
                <% } %>
                </SELECT>
            </td>
            </tr> 
	         <tr>
	         	<td><input type="submit" name="submit"></td>
	         </tr>
		</table>
	</form>
	<%@include file="footer.jsp" %>
</body>
</html>