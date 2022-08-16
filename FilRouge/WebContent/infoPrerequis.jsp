<%@page import="com.lip6.entities.Prerequis"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="form" scope="request" class="com.lip6.entities.Prerequis" ></jsp:useBean>
<body>
 
<form action="UpdatePrerequisServlet" method="POST">
	<table>		
		<tr>          
           <td><i>Modifier un Prerequis dans la base de donnée.</i> 
        </tr>
        <tr>
        	<td><i>Id Prerequis</i> <%= form.getIdPrerequis() %> </td>
         	<td><i>Nom du Prerequis</i> <%= form.getNomPrerequis() %>  </td>
           	
        <tr>
           	<td> <input type ="hidden" name="idPrerequis" type="number" value="<%= form.getIdPrerequis() %>"></td>
           	<td><i>Veuillez choisir le champ à modifier</i>
           		<SELECT name="champAModif" size="1">
					<OPTION value="nom"> Nom du Prerequis (<%= form.getNomPrerequis()%>)
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