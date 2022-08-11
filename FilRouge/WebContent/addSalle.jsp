<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin gestion salles</title>
</head>
<body>
	<form action="AddSalleServlet" method="post">
	    <table>
	    	<tr>
		    	<th>Partie admin</th>          
	            <td><i>Ajouter une salle dans la base de donn&#233e.</i> 
            </tr>
            <tr>
	            <td><i>Adresse</i> <input type="text" name="adresse">  </td></td>
	            <td><i>Nom Salle</i> <input type="text" name="nomSalle">  </td></td>
            </tr>
            <tr> 
            	<td><input type="submit" name="submit">  </td> 
            </tr>
    	</table>
  	</form>
  	<br>
  	<form action="SearchSalleServlet" method="post">
	    <table>
	    	<tr>
		    	<th>Partie admin</th>          
	            <td><i>Chercher une salle dans la base de donn&#233e.</i> 
            </tr>
            <tr>
	            <td><i>idSalle</i> <input type="number" name="idSalle">  </td>
            </tr>
            <tr> 
            	<td><input type="submit" name="submit">  </td> 
            </tr>
    	</table>
  	</form>
  	<form action="RemoveSalleServlet" method="post">
	    <table>
	    	<tr>
		    	<th>Partie admin</th>          
	            <td><i>Supprimer une salle dans la base de donn&#233e.</i> 
            </tr>
            <tr>
	            <td><i>idSalle</i> <input type="number" name="idSalle">  </td>
            </tr>
            <tr> 
            	<td><input type="submit" name="submit">  </td> 
            </tr>
    	</table>
  	</form>
</body>
</html>