<%@page import="com.lip6.entities.Theme"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="form" scope="request" class="com.lip6.entities.Theme" ></jsp:useBean>
<body>
 
<form action="UpdateThemeServlet" method="POST">
	<table>		
		<tr>          
           <td><i>Modifier un theme dans la base de donnée.</i> 
        </tr>
        <tr>
        	<td><i>Id theme</i> <%= form.getIdTheme() %> </td>
         	<td><i>Nom du theme</i> <%= form.getNomTheme() %>  </td>
           	
        <tr>
           	<td><i>Id theme</i> <input name="idTheme" type="number" value="<%= form.getIdTheme() %>"></td>
           	<td><i>Veuillez choisir le champ à modifier</i>
           		<SELECT name="champAModif" size="1">
					<OPTION value="nom"> Nom du theme (<%= form.getNomTheme()%>)
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