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
	            <%-- <td><i>Prerequis</i> <%= form.getPrerequisFormation() %> </td>  --%>
	            <%-- <td><i>Sessions</i> <%= form.getSessions() %>  </td>
	            <td><i>Theme</i> <%= form.getTheme() %>  </td>
	            <td><i>Chapitres </i> <%= form.getChapitres() %>  </td>     --%>      
	        </tr>
            <tr>
            	<td><i>IdFormation</i> <input name="idFormation" type="number" value="<%= form.getIdFormation()%>"></td>
            	<td><i>Veuillez rentrer le champ à modifier</i> <input name = "champAModif" type ="text" /></td>
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