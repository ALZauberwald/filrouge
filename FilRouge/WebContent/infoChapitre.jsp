<%@page import="com.lip6.entities.Prerequis"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="form" scope="request" class="com.lip6.entities.Chapitre" ></jsp:useBean>
<body>
 
<form action="UpdateChapitreServlet" method="POST">
	<table>		
		<tr>          
           <td><i>Modifier un Chapitre dans la base de donnée.</i> 
        </tr>
        <tr>
        	<td><i>Id Chapitre</i> <%= form.getIdChapitre() %> </td>
         	<td><i>Nom du Chapitre</i> <%= form.getNomChapitre() %>  </td>
         	<td><i>Durée du Chapitre</i> <%= form.getDureeChapitre()%>  </td>
         	<td><i>Détail du Chapitre</i> <%= form.getDetailChapitre() %>  </td>
         	
         	 <td><i>formation à laquelle ce chapitre est rattaché </i></br> <%= form.getFormation().getNomFormation() %></td>  
           	
           	
           	
        <tr>
           	<td><i>IdChapitre</i> <input name="idChapitre" type="number" value="<%= form.getIdChapitre() %>"></td>
           	<td><i>Veuillez choisir le champ à modifier</i>
           		<SELECT name="champAModif" size="1">
					<OPTION value="nom"> Nom du Chapitre (<%= form.getNomChapitre()%>)
					<OPTION value="duree"> Durée du Chapitre (<%= form.getDureeChapitre()%>)
					<OPTION value="detail"> Détail du Chapitre (<%= form.getDetailChapitre()%>)
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