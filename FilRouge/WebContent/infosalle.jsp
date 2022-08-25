<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styles.css">
<title>Insert title here</title>
</head>
<jsp:useBean id="salle" scope="request" class="com.lip6.entities.Salle" ></jsp:useBean>
<jsp:useBean id="sessionsdisponibles" scope="request" class="java.util.HashSet" ></jsp:useBean>
<body>
<%@ include file="header.jsp" %>
	<br>
	<br>
	<br>
	<br>
<form action="UpdateSalleServlet" method="POST">
	<table>
		<tr>
			<td><i>Id Salle</i> </br><%= salle.getIdSalle()%></td>
			<input type="hidden" type="number" name="idSalle" value="<%= salle.getIdSalle()%>"></td>
			<td><i>Adresse</i></br> <input type="text" name="adresse" value="<%=salle.getAdresse()%>">  </td>
			<td><i>Nom Salle</i></br> <input type="text" name="nomSalle" value="<%=salle.getNomSalle()%>">  </td>
			<td><i>Sessions</i> 
             	<% for (com.lip6.entities.Session ses:salle.getSessions()){ %>
   				</br><%= ses.getNomSession() %> 
				<% } %>   
			</td> 
		</tr>
		<tr>
	            <td><input type="submit" name="submit"></td>
	    </tr>
	</table>
</form>
<br>
<form action="UpdateSalle2Servlet" method="POST">
	<table>
<!-- Gestion des sessions -->  
         <tr>
           	<th>Vous voulez ajouter une session Ã  une salle ?</th><input type="HIDDEN" name="idSalle" type="number" value="<%= salle.getIdSalle()%>">    	
            	<td><i>Voici la liste des sessions disponibles</i>	
            		<SELECT size="1" name="idSession">
            			<% for (Object sess:sessionsdisponibles){%>
            				<OPTION VALUE="<%= sess.toString().split("  |  ")[0]%>"><%= sess %>	
						<% } %> 
					</SELECT> 
            	</td>
        <tr>
           	<td><button input type="submit" name="choix" value="assoSession">Ajouter la session</td>
        </tr>
           	<th>Vous voulez supprimer la session d'une salle ?</th><input type="HIDDEN" name="idSalleRm" type="number" value="<%= salle.getIdSalle()%>">
           	<td><i>Voici la liste des sessions qui sont pour l'instant liées à cette salle</i>
            	<SELECT size="1" name="idSessionRm">
             		<% for (com.lip6.entities.Session sess:salle.getSessions()){ %>
						<OPTION value="<%=sess.toString().split("  |  ")[0]%>"> <%= sess.getIdSession()%>  |  <%= sess.getNomSession() %>
					<% } %>  
				</SELECT>
           	</td>    	
         </tr>
         <tr>
           	<td><button input type="submit" name="choix" value="rmSession">Supprimer la session</td>
         </tr>     
            
	</table>

</form>
<%@include file="footer.jsp" %>
</body>
</html>