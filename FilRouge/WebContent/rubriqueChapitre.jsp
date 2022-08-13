<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Rubrique Chapitre</title>
</head>

<body>
	<h1>Ajouter un Chapitre</h1>
	<form action="AddChapitreServlet" method="POST">
		<table>			
			<tr>          
		       	<td><i>Ajouter un Chapitre à la liste des Chapitres de la base de donnée.</i> 
	        </tr>
	        <tr>
	            <td><i>nom du Chapitre</i><input type="text" name="nomChapitre"></td> 
	            <td><i>durée du Chapitre (en jour entier)</i><input type="text" name="dureeChapitre"></td> 
	            <td><i>détail</i><input type="text" name="detailChapitre"></td> 
	        </tr>            
	        <tr>
	           	<td><input type="submit" name="submit"></td>
	        </tr>
		</table>
	</form>
	
	
	<h1>Rechercher un Chapitre déjà existant</h1>
	<br>
	<form action="SearchChapitreServlet" method="POST">
		<table>		
			<tr>          
	          	<td><i>Rechercher un Chapitre</i> 
	         </tr>
	         <tr>        	
	         	<td><i>Veuillez renseigner l'id du Chapitre que vous recherchez</i> <input type="number" name="idChapitre"></td>
	         </tr>        
	         <tr>
	         	<td><input type="submit" name="submit"></td>
	         </tr>
		</table>
	</form>
	
	
	<h1>Supprimer un Chapitre déjà existant</h1>
	<br>
	<form action="RemoveChapitreServlet" method="POST">
		<table>		
			<tr>          
	         	<td><i>Supprimer un Chapitre de la base de donnée.</i> 
	        </tr>
	        <tr>     	
	           	<td><i>Veuillez renseigner l'id du Chapitre que vous souhaitez supprimer</i> <input type="number" name="idChapitre">  </td>       
	        <tr>
	            <td><input type="submit" name="submit"></td>
	        </tr>
		</table>
	</form>
</body>
</html>