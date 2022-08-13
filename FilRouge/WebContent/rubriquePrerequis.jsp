<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Rubrique Prerequis</title>
</head>

<body>
	<h1>Ajouter un Prerequis</h1>
	<form action="AddPrerequisServlet" method="POST">
		<table>			
			<tr>          
		       	<td><i>Ajouter un Prerequis à la liste des Prerequis de la base de donnée.</i> 
	        </tr>
	        <tr>
	            <td><i>Veuillez renseigner le nom du Prerequis</i><input type="text" name="nomPrerequis"></td> 
	        </tr>            
	        <tr>
	           	<td><input type="submit" name="submit"></td>
	        </tr>
		</table>
	</form>
	
	
	<h1>Rechercher un Prerequis déjà existant</h1>
	<br>
	<form action="SearchPrerequisServlet" method="POST">
		<table>		
			<tr>          
	          	<td><i>Rechercher un Prerequis</i> 
	         </tr>
	         <tr>        	
	         	<td><i>Veuillez renseigner l'id du prerequis que vous recherchez</i> <input type="number" name="idPrerequis"></td>
	         </tr>        
	         <tr>
	         	<td><input type="submit" name="submit"></td>
	         </tr>
		</table>
	</form>
	
	
	<h1>Supprimer un Prerequis déjà existant</h1>
	<br>
	<form action="RemovePrerequisServlet" method="POST">
		<table>		
			<tr>          
	         	<td><i>Supprimer un Prerequis de la base de donnée.</i> 
	        </tr>
	        <tr>     	
	           	<td><i>Veuillez renseigner l'id du Prerequis que vous souhaitez supprimer</i> <input type="number" name="idPrerequis">  </td>       
	        <tr>
	            <td><input type="submit" name="submit"></td>
	        </tr>
		</table>
	</form>
</body>
</html>