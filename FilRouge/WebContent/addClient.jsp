<%@page import="com.lip6.entities.Client"%>
<%@page import="com.lip6.services.ClientService"%>
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
<%@ include file="header.jsp" %>
	<br>
	<br>
	<br>
	<br>
	<form action="AddClientServlet" method="POST">
		<table>
			
			<tr>          
	            <h1>Ajouter un nouveau client</h1> 
            </tr>
            <tr> 
            	<td><i>Id de la session</i><input type="number" name="idSession"></td> 
            	<td><i>Veuillez rentrer le nom</i> <input type="text" name="nomClient">  </td>
	            <td><i>Veuillez rentrer le prénom</i> <input type="text" name="prenomClient">  </td>
	            <td><i>Veuillez rentrer l'adresse</i> <input type="text" name="adresse">  </td>
	            <td><i>Veuillez rentrer le numéro de téléphone</i> <input type="text" name="tel">  </td>
	            <td><i>Veuillez rentrer le mail</i> <input type="text" name="mail">  </td>
	            <td><i>Veuillez rentrer le numéro de Siret</i> <input type="text" name="numSiret">  </td>
	            
            </tr>
            
            <tr>
            <td><input type="submit" name="submit"></td>
            </tr>
		</table>
	</form>
		<br>
	<form action="SearchClientServlet" method="POST">
		<table>		
			<tr>          
	          	<h1>Rechercher un client existant</h1>
	         </tr>
	        <tr>
            	<td>
            	<SELECT name="idClient" >
            <%ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());%>
    		<%ClientService clientserv= context.getBean("servClient",ClientService.class);%>
    		<%java.util.Set<Client> clientsdisponibles = clientserv.recupClient(); %>
    		<% for (Object client:clientsdisponibles){ %>
                   </br><OPTION Value="<%=client.toString().split("  |  ")[0]%>"><%= client %>
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
	<form action="RemoveClientServlet" method="POST">
		<table>		
			<tr>          
	          <h1>Supprimer un client existant</h1> 
	        </tr>
	        <tr>
	        <td>
            	<SELECT name="idClient" >
    			<% for (Object client:clientsdisponibles){ %>
                   </br><OPTION Value="<%=client.toString().split("  |  ")[0]%>"><%= client %>
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