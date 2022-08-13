<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Rubrique objectif</title>
</head>

<body>
	<h1>Ajouter un objectif</h1>
	<form action="AddObjectifServlet" method="POST">
		<table>			
			<tr>          
		       	<td><i>Ajouter un objectif à la liste des objectifs de la base de donnée.</i> 
	        </tr>
	        <tr>
	            <td><i>Veuillez renseigner le nom de l'objectif</i><input type="text" name="nomObjectif"></td> 
	        </tr>            
	        <tr>
	           	<td><input type="submit" name="submit"></td>
	        </tr>
		</table>
	</form>
	
	
	<h1>Rechercher un objectif déjà existant</h1>
	<br>
	<form action="SearchObjectifServlet" method="POST">
		<table>		
			<tr>          
	          	<td><i>Rechercher un objectif</i> 
	         </tr>
	         <tr>        	
	         	<td><i>Veuillez renseigner l'id de l'objectif que vous recherchez</i> <input type="number" name="idObjectif"></td>
	         </tr>        
	         <tr>
	         	<td><input type="submit" name="submit"></td>
	         </tr>
		</table>
	</form>
	
	
	<h1>Supprimer un objectif déjà existant</h1>
	<br>
	<form action="RemoveObjectifServlet" method="POST">
		<table>		
			<tr>          
	         	<td><i>Supprimer un objectif de la base de donnée.</i> 
	        </tr>
	        <tr>     	
	           	<td><i>Veuillez renseigner l'id de l'objectif que vous souhaitez supprimer</i> <input type="number" name="idObjectif">  </td>       
	        <tr>
	            <td><input type="submit" name="submit"></td>
	        </tr>
		</table>
	</form>
</body>
</html>