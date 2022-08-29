<%@page import="com.lip6.entities.Prerequis"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styles.css">
<title>Insert title here</title>
</head>
<jsp:useBean id="form" scope="request" class="com.lip6.entities.Objectif" ></jsp:useBean>
<body>
 <%@ include file="header.jsp" %>
	<br>
	<br>
	<br>
	<br>
	<div class="epais">
<form action="UpdateObjectifServlet" method="POST">
	<table>		
		<tr>          
           <td><i>Modifier un objectif dans la base de donnée.</i> 
        </tr>
        <tr>
        	<td><i>Id objectif</i> <%= form.getIdObjectif() %> </td>
         	<td><i>Nom de l'objectif</i> <%= form.getNomObjectif() %>  </td>
           	
        <tr>
           	<td> <input type ="hidden" name="idObjectif" type="number" value="<%= form.getIdObjectif() %>"></td>
           	<td><i>Veuillez choisir le champ à modifier</i>
           		<SELECT name="champAModif" size="1">
					<OPTION value="nom"> Nom de l'objectif (<%= form.getNomObjectif()%>)
				</SELECT> 
           	<td><i>Veuillez rentrer la valeur du champ à modifier</i> <input name="modif" type="text" /></td>
      	</tr>
        <tr>
            <td><input type="submit" name="submit"></td>
        </tr>
	</table>
</form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>