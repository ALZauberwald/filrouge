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
<body>
 
<form action="UpdateFormationServlet" method="POST">
<table>
			
			<tr>          
	            <td><i>Modifier une formation dans la base de donnée.</i> 
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
            	<td><i>Veuillez choisir le champ à modifier</i>
            		<SELECT name="champAModif" size="1">
						<OPTION value="nom"> Nom de la formation (<%= form.getNomFormation()%>)
						<OPTION value="detail"> Detail de la formation (<%= form.getDetailFormation()%>)
					</SELECT> 
            	<td><i>Veuillez rentrer la valeur du champ à modifier</i> <input name="modif" type="text" /></td>
            </tr>
            <tr>
            <td><input type="submit" name="submit"></td>
            </tr>
</table>
</form>
<br>
</body>
</html>