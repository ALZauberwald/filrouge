<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Rubrique Theme</title>
</head>

<body>
	<h1>Ajouter un Theme</h1>
	<form action="AddThemeServlet" method="POST">
		<table>			
			<tr>          
		       	<td><i>Ajouter un Theme à la liste des Themes de la base de donnée.</i> 
	        </tr>
	        <tr>
	            <td><i>Veuillez renseigner le nom du Theme</i><input type="text" name="nomTheme"></td> 
	        </tr>            
	        <tr>
	           	<td><input type="submit" name="submit"></td>
	        </tr>
		</table>
	</form>
	
	
	<h1>Rechercher un theme déjà existant</h1>
	<br>
	<form action="SearchThemeServlet" method="POST">
		<table>		
			<tr>          
	          	<td><i>Rechercher un theme</i> 
	         </tr>
	         <tr>        	
	         	<td><i>Veuillez renseigner l'id du theme que vous recherchez</i> <input type="number" name="idTheme"></td>
	         </tr>        
	         <tr>
	         	<td><input type="submit" name="submit"></td>
	         </tr>
		</table>
	</form>
	
	
	<h1>Supprimer un theme déjà existant</h1>
	<br>
	<form action="RemoveThemeServlet" method="POST">
		<table>		
			<tr>          
	         	<td><i>Supprimer un theme de la base de donnée.</i> 
	        </tr>
	        <tr>     	
	           	<td><i>Veuillez renseigner l'id du theme que vous souhaitez supprimer</i> <input type="number" name="idTheme">  </td>       
	        <tr>
	            <td><input type="submit" name="submit"></td>
	        </tr>
		</table>
	</form>
</body>
</html>