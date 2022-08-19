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
<!-- <div ><h1 >Trouver une formation &#224 distance ou en pr&#233sentiel</h1>
	<form action="KeyWordServlet" method="post">
		<table>
		    <tr>  
		    <th>Partie client</th>          
		        <td><i>Quelle formation recherchez-vous?</i><input type="text" name="keyword">  </td>       
		    </tr>
		    <tr>
		        <td><input type="submit" name="submit">  </td> 
		    </tr>    
		</table>
	</form>
</div>
	
	

	 <br><br>
 -->
		<div class="center"><h1 >Gestion Administrateur</h1></div>
	<br><br>
		<h1><a href="creersession.jsp">Rubrique Session</a></h1>
	<br><br>
	
	<br><br>
		<h1><a href="addSalle.jsp">Rubrique Salle</a></h1>
	<br><br> 
	<br><br>
		<h1><a href="addStagiaire.jsp">Rubrique stagiaire</a></h1>
	<br><br> 
	<br><br>
		<h1><a href="addFormateur.jsp">Rubrique formateur</a></h1>
	<br><br> 
	<br><br>
		<h1><a href="addClient.jsp">Rubrique client</a></h1>
	<br><br>
	

		 <h1><a href="rubriquePrerequis.jsp">Creer, rechercher, supprimer ou mettre Ã  jour un prerequis</a></h1>

	<br><br>
	
	 <br><br>
		<h1><a href="rubriqueObjectif.jsp">Creer, rechercher, supprimer ou mettre Ã  jour un objectif</a></h1>
	<br><br> 
	
	<br><br>
		<h1><a href="rubriqueChapitre.jsp">Creer, rechercher, supprimer ou mettre Ã  jour un chapitre</a></h1>
	<br><br> 
	
	<br><br>
		<h1><a href="rubriqueTheme.jsp">Creer, rechercher, supprimer ou mettre a  jour un theme</a></h1>
	<br><br>  
	
	<br><br>
		<h1><a href="rubriqueFormation.jsp">Creer, rechercher, supprimer ou mettre a  jour une formation</a></h1>
	<br><br>
    <%@include file="footer.jsp" %>	
</body>
</html>