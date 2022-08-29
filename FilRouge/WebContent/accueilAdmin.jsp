<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styles.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<title>Test</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<br>
	<br>
	<br>
	<br>

 <div class="retreci">
	 <table  class="table"><caption class="caption-top aligncenter">Gestion administrateur<br></caption>
	 	<tr id="admintr">
	 		 <th id="adminblanc"></th>
	 		 <td class="table-info" id="admintd"><a href="rubriqueSession.jsp" class="link-dark">Rubrique Session</a></td>
	 		 <td class="table-light" id="admintd"><a href="rubriqueFormation.jsp" class="link-dark">Rubrique formation</a></td>
	 	</tr>
	 	<tr id="admintr">
	 		 <td class="table-info" id="admintd" id="afftd"><a href="rubriqueStagiaire.jsp" class="link-dark">Rubrique stagiaire</a></td>
	 		 <td class="table-light" id="admintd"><a href="rubriqueFormateur.jsp" class="link-dark">Rubrique formateur</a></td>
	 		 <td class="table-info" id="admintd"><a href="rubriquePrerequis.jsp" class="link-dark">Rubrique prerequis</a></td>
	 		 <td class="table-light" id="admintd"><a href="rubriqueObjectif.jsp" class="link-dark">Rubrique objectif</a></td>	 
	 	</tr>
	 	<tr id="admintr">
	 		 <td class="table-light" id="admintd"><a href="rubriqueSalle.jsp" class="link-dark">Rubrique Salle</a></td>
	 		 <td class="table-info" id="admintd"><a href="rubriqueClient.jsp" class="link-dark">Rubrique client</a></td>
	 		 <td class="table-light" id="admintd"><a href="rubriqueChapitre.jsp" class="link-dark">Rubrique chapitre</a></td>
	 		 <td class="table-info" id="admintd"><a href="rubriqueTheme.jsp" class="link-dark">Rubrique theme</a></td>
	 	</tr>
	 </table>
 </div>
 
		
    <%@include file="footer.jsp" %>	
</body>
</html>