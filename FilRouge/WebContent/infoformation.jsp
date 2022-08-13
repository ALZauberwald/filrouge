<%@page import="com.lip6.entities.Prerequis"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="form" scope="request" class="com.lip6.entities.Formation" ></jsp:useBean>
<jsp:useBean id="objectifsdisponibles" scope="request" class="java.util.HashSet" ></jsp:useBean>


<body>
 
<form action="UpdateFormationServlet" method="POST">
	<table>
			
			<tr>          
	            <td><i>Modifier une formation dans la base de donn�e.</i> 
            </tr>
            <tr>
            	<td><i>Id Formation</i> <%= form.getIdFormation() %> </td>
             	<td><i>nomFormation</i> <%= form.getNomFormation() %>  </td>
             	<td><i>Detail de la formation</i> <%= form.getDetailFormation() %>  </td>
             	
	             <td><i>Objectifs</i>            
	           		<% for (com.lip6.entities.Objectif objectif:form.getObjectifsFormation()){ %>
    				<%= objectif.getNomObjectif() %> </br>
 					<% } %> 
	            </td>
	             <td><i>Prerequis</i> 
	            	<% for (com.lip6.entities.Prerequis prerequis:form.getPrerequisFormation()){ %>
    				<%= prerequis.getNomPrerequis() %> </br>
 					<% } %> 
 					</td> 
	             <td><i>Sessions</i> 
	             	<% for (com.lip6.entities.Session ses:form.getSessions()){ %>
    				<%= ses.getNomSession() %> </br>
 					<% } %>   
 				</td>
	            
	             <td><i>Theme</i> 
	             	<% for (com.lip6.entities.Theme th:form.getTheme()){ %>
    				<%= th.getNomTheme() %> </br>
 					<% } %>   
 				</td>
	            <td><i>Chapitres </i> 
	            	<% for (com.lip6.entities.Chapitre cp:form.getChapitres()){ %>
    				<%= cp.getNomChapitre() %> </br>
 					<% } %>   
 				</td>     
	        </tr>
            <tr>
            	<td><i>IdFormation</i> <input name="idFormation" type="number" value="<%= form.getIdFormation()%>"></td>
            	<td><i>Veuillez choisir le champ � modifier</i>
            		<SELECT name="champAModif" size="1">
						<OPTION value="nom"> Nom de la formation (<%= form.getNomFormation()%>)
						<OPTION value="detail"> Detail de la formation (<%= form.getDetailFormation()%>)
					</SELECT> 
            	<td><i>Veuillez rentrer la valeur du champ � modifier</i> <input name="modif" type="text" /></td>
            </tr>
            <tr>
            <td><input type="submit" name="submit"></td>
            </tr>
       </table>
</form>


<form action="UpdateFormation2Servlet" method="POST">
	<table>
            <tr>
            	<th>Vous voulez ajouter un objectif � la formation ?</th>
            	<td><i>Choisissez l'objectif � rajouter parmi ceux disponible</i>
            	
            	<SELECT name="searchObjectif" size="1">
            		<% for (Object objectif:objectifsdisponibles){%>
            			<% %>
						<%-- <OPTION value="objectif"> <%= objectif%> --%>
						<OPTION value=<%String valeur = objectif.toString().split("idObjectif=")[1].split(",")[0];%>)> <%= objectif.toString().split("nomObjectif=")[1].split("]")[0]%>
						<%-- <OPTION value="objectif"> <%= objectif.toString().split("idObjectif=")[1].split(",")[0]%> --%>
						
					<% } %> 
				</SELECT> 
            	</td>
            	
            	
            	
            	<th>Vous voulez modifier ou supprimer un objectif de la formation ?</th>
            	<td><i>Choisissez d'abord l'objectif concern�</i>
            	<SELECT name="searchObjectif" size="1">
            		<% for (com.lip6.entities.Objectif objectif:form.getObjectifsFormation()){%>
						<OPTION value="objectif"> <%= objectif.getNomObjectif()%>
					<% } %> 
				</SELECT> 
            	</td>
            	<%-- <td> <%= objectifsdisponibles%></td> --%>
            </tr>
            <tr>
            	<td><input type="submit" name="submit"></td>
            </tr>
</table>
</form>
<br>
</body>
</html>