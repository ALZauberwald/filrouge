<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddFormateurServlet" method="POST">
		<table>
			
			<tr>          
	            <td><i>Ajouter une session � la base de donn�e.</i> 
            </tr>
            <tr> 
            	<td><i>Veuillez rentrer le nom</i> <input type="text" name="nomFormateur">  </td>
	            <td><i>Veuillez rentrer le pr�nom</i> <input type="text" name="prenomFormateur">  </td>
	            <td><i>Veuillez rentrer l'adresse</i> <input type="text" name="adresse">  </td>
	            <td><i>Veuillez rentrer le num�ro de t�l�phone</i> <input type="text" name="tel">  </td>
	            <td><i>Veuillez rentrer le mail</i> <input type="text" name="mail">  </td>
	            <td><i>Veuillez rentrer la date d'embauche</i> <input type="text" name="dateEmbauche">  </td>
	            
            </tr>
            
            <tr>
            <td><input type="submit" name="submit"></td>
            </tr>
		</table>
	</form>
	<br>
	<h1>Rechercher un formateur existant</h1>
	<br>
	<form action="SearchFormateurServlet" method="POST">
		<table>		
			<tr>          
	          	<td><i>Rechercher un formateur</i> 
	         </tr>
	         <tr>        	
	         	<td><i>Veuillez renseigner le nom du formateur</i> <input type="text" name="nom"></td>
	         </tr> 
	         <tr>        	
	         	<td><i>Veuillez renseigner le pr�nom du formateur</i> <input type="text" name="prenom"></td>
	         </tr>       
	         <tr>
	         	<td><input type="submit" name="submit"></td>
	         </tr>
		</table>
	</form>
	<br>
	<h1>Supprimer un formateur existant</h1>
	<br>
	<form action="RemoveFormateurServlet" method="POST">
		<table>		
			<tr>          
	          	<td><i>Supprimer un formateur</i> 
	         </tr>
	         <tr>        	
	         	<td><i>Veuillez renseigner le nom du formateur</i> <input type="text" name="nom"></td>
	         </tr> 
	         <tr>        	
	         	<td><i>Veuillez renseigner le pr�nom du formateur</i> <input type="text" name="prenom"></td>
	         </tr>       
	         <tr>
	         	<td><input type="submit" name="submit"></td>
	         </tr>
		</table>
	</form>
</body>
</html>