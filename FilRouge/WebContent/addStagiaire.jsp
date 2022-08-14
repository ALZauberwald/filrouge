<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddStagiaireServlet" method="POST">
		<table>
			
			<tr>          
	            <td><i>Ajouter une session à la base de donnée.</i> 
            </tr>
            <tr>
            	<td><i>Id de la session</i><input type="number" name="idSession"></td> 
            	<td><i>Veuillez rentrer votre nom</i> <input type="text" name="nomStagiaire">  </td>
	            <td><i>Veuillez rentrer votre prénom</i> <input type="text" name="prenomStagiaire">  </td>
	            <td><i>Veuillez rentrer votre adresse</i> <input type="text" name="adresse">  </td>
	            <td><i>Veuillez rentrer votre numéro de téléphone</i> <input type="text" name="tel">  </td>
	            <td><i>Veuillez rentrer votre mail</i> <input type="text" name="mail">  </td>
            </tr>
            
            <tr>
            <td><input type="submit" name="submit"></td>
            </tr>
		</table>
	</form>
	<br>
	<form action="SearchStagiaireServlet" method="POST">
		<table>		
			<tr>          
	          	<td><i>Rechercher un Stagiaire</i> 
	         </tr>
	         <tr>        	
	         	<td><i>Veuillez renseigner le nom du stagiaire</i> <input type="text" name="nom"></td>
	         </tr> 
	         <tr>        	
	         	<td><i>Veuillez renseigner le prénom du stagiaire</i> <input type="text" name="prenom"></td>
	         </tr>       
	         <tr>
	         	<td><input type="submit" name="submit"></td>
	         </tr>
		</table>
	</form>
	<br>
	<form action="RemoveStagiaireServlet" method="POST">
		<table>		
			<tr>          
	          	<td><i>Remove un Stagiaire</i> 
	         </tr>
	         <tr>        	
	         	<td><i>Veuillez renseigner le nom du stagiaire</i> <input type="text" name="nom"></td>
	         </tr> 
	         <tr>        	
	         	<td><i>Veuillez renseigner le prénom du stagiaire</i> <input type="text" name="prenom"></td>
	         </tr>       
	         <tr>
	         	<td><input type="submit" name="submit"></td>
	         </tr>
		</table>
	</form>
</body>
</html>