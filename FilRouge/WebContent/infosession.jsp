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
            	<td><i>Id Session</i> <%= sess.getIdSession()%></td>
             	<td><i>nomSession</i> <%= sess.getNomSession() %>  </td>
             	<td><i>nomFormation</i> <%= sess.getFormation().getNomFormation() %>  </td>
	            <td><i>prix</i> <%= sess.getPrix() %>  </td>
	            <td><i>dateDebut</i> <%= sess.getDateDebut() %> </td>
	            <td><i>lieu</i> <%= sess.getLieu() %>  </td>
	            <td><i>formateurConfirmé</i> <%= sess.isFormateurConfirme() %>  </td>
	            <td><i>typeSession</i> <%= sess.getTypeSession() %>  </td>
	 	        <td><i>adresse</i> <%= sess.getSalle().getAdresse()%>  </td>
	            <td><i>nomSalle</i> <%= sess.getSalle().getNomSalle()%> </td>
	            <td><i>installationFinie</i> <%= sess.isInstallationFinie() %></td>	 
	            <td><i>idFormateur</i> <%= sess.getFormateur() %></td>	 
	            <td><i>idSalle</i> <%=sess.getSalle().getIdSalle() %>  </td>        
	            
             </tr>
            <tr>
            	<td><i>IdSession</i> <input name="idSession" type="number" value="<%= sess.getIdSession()%>"></td>
            	<td><i>Veuillez rentrer le champ à modifier</i> <input name = "champAModif" type ="text" /></td>
            	<td><i>Veuillez rentrer la valeur du champ à modifier</i> <input name="modif" type="text" /></td>
            </tr>
            <tr>
            <td><input type="submit" name="submit"></td>
            </tr>
</table>
</form>
<br>
</body>
</html>