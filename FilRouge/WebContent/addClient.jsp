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
	            <td><i>Ajouter une session � la base de donn�e.</i> 
            </tr>
            <tr> 
            	<td><i>Veuillez rentrer le nom</i> <input type="text" name="nomClient">  </td>
	            <td><i>Veuillez rentrer le pr�nom</i> <input type="text" name="prenomClient">  </td>
	            <td><i>Veuillez rentrer l'adresse</i> <input type="text" name="adresse">  </td>
	            <td><i>Veuillez rentrer le num�ro de t�l�phone</i> <input type="text" name="tel">  </td>
	            <td><i>Veuillez rentrer le mail</i> <input type="text" name="mail">  </td>
	            <td><i>Veuillez rentrer le num�ro de Siret</i> <input type="text" name="numSiret">  </td>
	            
            </tr>
            
            <tr>
            <td><input type="submit" name="submit"></td>
            </tr>
		</table>
	</form>
</body>
</html>