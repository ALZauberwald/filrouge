<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddClientServlet" method="POST">
		<table>
			
			<tr>          
	            <td><i>Ajouter une session à la base de donnée.</i> 
            </tr>
            <tr> 
            	<td><i>Veuillez rentrer le nom</i> <input type="text" name="nomClient">  </td>
	            <td><i>Veuillez rentrer le prénom</i> <input type="text" name="prenomClient">  </td>
	            <td><i>Veuillez rentrer l'adresse</i> <input type="text" name="adresse">  </td>
	            <td><i>Veuillez rentrer le numéro de téléphone</i> <input type="text" name="tel">  </td>
	            <td><i>Veuillez rentrer le mail</i> <input type="text" name="mail">  </td>
	            <td><i>Veuillez rentrer le numéro de Siret</i> <input type="text" name="numSiret">  </td>
	            
            </tr>
            
            <tr>
            <td><input type="submit" name="submit"></td>
            </tr>
		</table>
	</form>
</body>
</html>