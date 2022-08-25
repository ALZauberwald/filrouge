<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styles.css">
<title>Test</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<br>
	<br>
	<br>
	<br>


 <br><br><br><br>
 <table id="admintable"><caption>Gestion administrateur</caption>
 	<tr id="admintr">
 		 <th></th>
 		 <td id="admintd"><a href="rubriqueSession.jsp">Rubrique Session</a></td>
 		 <td id="admintd"><a href="rubriqueFormation.jsp">Rubrique formation</a></td>
 	</tr>
 	<tr id="admintr">
 		 <td id="admintd"><a href="rubriqueStagiaire.jsp">Rubrique stagiaire</a></td>
 		 <td id="admintd"><a href="rubriqueFormateur.jsp">Rubrique formateur</a></td>
 		 <td id="admintd"><a href="rubriquePrerequis.jsp">Rubrique prerequis</a></td>
 		 <td id="admintd"><a href="rubriqueObjectif.jsp">Rubrique objectif</a></td>	 
 	</tr>
 	<tr id="admintr">
 		 <td id="admintd"><a href="rubriqueSalle.jsp">Rubrique Salle</a></td>
 		 <td id="admintd"><a href="rubriqueClient.jsp">Rubrique client</a></td>
 		 <td id="admintd"><a href="rubriqueChapitre.jsp">Rubrique chapitre</a></td>
 		 <td id="admintd"><a href="rubriqueTheme.jsp">Rubrique theme</a></td>
 	</tr>

 
 
 </table>
 
 
		
    <%@include file="footer.jsp" %>	
</body>
</html>