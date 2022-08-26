<%@page import="com.lip6.entities.Formation"%>
<%@page import="com.lip6.services.FormationService"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/styles.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<title>Rubrique Formation</title>
</head>


<body>
<%@ include file="header.jsp" %>
	<br>
	<br>
	<br>
	<br>
	<div class="retreci">
		<form action="AddFormServlet" method="post">
		    <table class="table "id ="afftbl"><caption class="caption-top aligncenter">Ajouter une nouvelle formation<br></caption>
	            <tr class="table-info">
		            <td id="afftd">Nom de la formation</td>
		            <td id="afftd">Detail de la formation</td>
		            <td id="afftd">Ajouter</td>
	            </tr>
	            <tr>
	             	<td id="afftd"><input type="text" name="formationname"></td>
	             	<td id="afftd"><input type="text" name="formationdetail"></td>
	            	<td id="afftd"><input type="submit" name="submit">  </td> 
	            </tr>
	    	</table>
	  	</form>
	  	
		<form action="SearchFormationServlet" method="post">
		    <table class="table "id ="afftbl"><caption class="caption-top aligncenter">Rechercher une formation<br></caption>
	            <tr class="table-info">
	            	<td id ="afftd">Id et Nom de la Formation</td>
	            	<td id ="afftd">Rechercher</td>
	            </tr>
	            <tr>
	            	<td id ="afftd"><Select name ="idFormation">
			            <%ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());%>
	    				<%FormationService formaserv= context.getBean("servFormation",FormationService.class);%>
						<%java.util.Set<Formation> formationsdisponibles = formaserv.recupFormations(); %>
						<% for (Object formation:formationsdisponibles){ %>
		   				</br><option value ="<%= formation.toString().split("  |  ")[0]%>"><%= formation %> </option>
						<% } %>
						</Select>
					</td>
					<td id ="afftd"><input type="submit" name="submit" value="rechercher">  </td> 
	            </tr>
	    	</table>
	  	</form>
		<form action="RemoveFormServlet" method="post">
		    <table class="table "id ="afftbl"><caption class="caption-top aligncenter">Supprimer une formation<br></caption>
	            <tr class="table-info">
			    	<td id ="afftd">Id et Nom de la Formation</td>
	            	<td id ="afftd">Supprimer</td>
	            </tr>
	            <tr>
	            	<td id ="afftd">
	            		<Select name ="idFormation">
			            	<!-- <td><i>Id de la formation a rechercher</i> <input type="number" name="idFormation">  </td> -->
							<% for (Object formation:formationsdisponibles){ %>
			   				</br><option value ="<%= formation.toString().split("  |  ")[0]%>"><%= formation %> </option>
							<% } %>
						</Select>
					</td>
					<td id ="afftd"><input type="submit" name="submit" value="supprimer">  </td> 
		        </tr>
	            <tr> 
	            	
	            </tr>
	    	</table>
	  	</form>
  	</div>
<%@include file="footer.jsp" %>
</body>
</html>