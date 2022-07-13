<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Partie admin</h1>
<form action="CreerSession" method="POST">
<table>
			
			<tr>          
	            <td><i>Ajouter une formation à la base de donnée.</i> 
            </tr>
            <tr>
            	
            	<td><i>Veuillez rentrer le nom de la session</i> <input type="text" name="nomsession">  </td>
	            <td><i>Prix de la session</i> <input type="text" name="prix">  </td>
	            <td><i>Date de début de la formation</i> <input type="text" name="datedebut">  </td>
	            <td><i>Lieu de la session</i> <input type="text" name="lieusession">  </td>
	            <td><i>Type de session</i> <input type="text" name="typesession">  </td>
            </tr>
</table>
</form>
</body>
</html>