<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="salle" scope="request" class="com.lip6.entities.Salle" ></jsp:useBean>
<jsp:useBean id="sessionsdisponibles" scope="request" class="java.util.HashSet" ></jsp:useBean>
<body>
<form action="UpdateSalleServlet" method="POST">
	<table>
		<tr>
			<td><i>Id Salle</i> <input type="number" name="idSalle" value="<%= salle.getIdSalle()%>"></td>
			<td><i>Adresse</i> <input type="text" name="adresse" value="<%=salle.getAdresse()%>">  </td>
			<td><i>Nom Salle</i> <input type="text" name="nomSalle" value="<%=salle.getNomSalle()%>">  </td>
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
            		<SELECT size="1">
            			<% for (Object sess:sessionsdisponibles){%>
            				<OPTION><%= sess %>	
						<% } %> 
					</SELECT> 
            	</td>
            	<td><i>Indiquez simplement le numÃ©ro de la session que vous souhaitez ajouter</i><input name="idSession" type="number" ></td>
        <tr>
           	<td><button input type="submit" name="choix" value="assoSession">Ajouter la session</td>
        </tr>
           	<th>Vous voulez supprimer la salle d'une session ?</th><input type="HIDDEN" name="idSalleRm" type="number" value="<%= salle.getIdSalle()%>">
           	<td><i>Voici la liste des sessions qui sont pour l'instant liées à cette salle</i>
            	<SELECT size="1">
             		<% for (com.lip6.entities.Session sess:salle.getSessions()){ %>
						<OPTION value="Session"> <%= sess.getIdSession()%>  |  <%= sess.getNomSession() %>
					<% } %>  
				</SELECT>
           	</td>
           	<td><i>Indiquez simplement le numÃ©ro de la session que vous souhaitez supprimer</i><input name="idSessionRm" type="number" >
            	
         </tr>
         <tr>
           	<td><button input type="submit" name="choix" value="rmSession">Supprimer la session</td>
         </tr>     
            
	</table>

</form>
</body>
</html>