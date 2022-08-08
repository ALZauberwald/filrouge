<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="sess" scope="request" class="com.lip6.entities.Session" ></jsp:useBean>
<body>
 
<form action="UpdateSessionServlet" method="POST">
<table>
			
			<tr>          
	            <td><i>Modifier une session dans la base de donnée.</i> 
            </tr>
            <tr>
            	<td><i>Id de l'objet</i> <input type="number" name="idSession" value="<%= sess.getIdSession()%>">
             	<td><i>Veuillez rentrer le nom de la session</i> <input type="text" name="nomSession" value="<%= sess.getNomSession() %>">  </td>
	            <td><i>Prix de la session</i> <input type="text" name="prix" value="<%= sess.getPrix() %>">  </td>
	            <td><i>Date de début de la session</i> <input type="text" name="dateDebut" value="<%= sess.getDateDebut() %>">  </td>
	            <td><i>Ville de la session</i> <input type="text" name="lieuSession" value="<%= sess.getLieu() %>">  </td>
	            <td><i>Formateur confirmé</i> <input type="text" name="formateur" value="<%= sess.isFormateurConfirme() %>">  </td>
	            <td><i>Type de session</i> <input type="text" name="typeSession" value="<%= sess.getTypeSession() %>">  </td>
	 	        <td><i>Adresse de la session</i> <input type="text" name="adresse" value="<%= sess.getSalle().getAdresse()%>">  </td>
	 	        <td><i>Id salle</i> <input type="text" name="idSalle" value="<%= sess.getSalle().getIdSalle() %>">  </td>
	            <td><i>Nom de la salle</i> <input type="text" name="nomSalle" value="<%= sess.getSalle().getNomSalle()%>">  </td>
	            <td><i>Type de session</i> <input type="text" name="install" value="<%= sess.getSalle().getInstallationFinie() %>">
	            <td><i>id formation</i> <input type="text" name="idFormation" value="<%= sess.getFormation().getIdFormation() %>">  </td>
	            <td><i>nom formation</i> <input type="text" name="nomFormation" value="<%= sess.getFormation().getNomFormation() %>">  </td>
	            <td><i>detail formation</i> <input type="text" name="detailFormation" value="<%= sess.getFormation().getDetailFormation() %>">  </td>
	            
	            
             </tr>
            
            <tr>
            <td><input type="submit" name="submit"></td>
            </tr>
</table>
</form>
<br>
</body>
</html>