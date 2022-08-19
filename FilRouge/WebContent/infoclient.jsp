<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="cli" scope="request" class="com.lip6.entities.Client" ></jsp:useBean>
<jsp:useBean id="sessionsdisponibles" scope="request" class="java.util.HashSet"></jsp:useBean>
<body>
<%@ include file="header.jsp" %>
	<br>
	<br>
	<br>
	<br>
<form action="UpdateClientServlet" method="POST">
	<table>
		<tr>
			<td><i>Id client</i></br> <%=cli.getId() %></td>
			<td><i>Nom</i></br> <%=cli.getNom() %>  </td>
			<td><i>Prenom</i></br> <%=cli.getPrenom() %></td>
			<td><i>Adresse</i></br> <%=cli.getAdresse() %> </td>
			<td><i>Tel</i></br><%=cli.getTel() %> </td>
			<td><i>Mail</i></br> <%=cli.getMail()%></td>
			<td><i>Numero Siret</i></br> <%=cli.getNumSiret() %></td>
			<td><i>Sessions</i> 
             	<% for (com.lip6.entities.Session ses:cli.getSessions()){ %>
   				</br><%= ses.getNomSession() %> 
				<% } %>   
			</td> 
		</tr>
		<tr>
        	<h2>Pour modifier un champ</h2>
        	<input type="HIDDEN" name="idClient" type="number" value="<%= cli.getId()%>">
           	
           	<td><i>Veuillez choisir le champ Ã  modifier</i></br>
           		<SELECT name="champAModif" size="1">
					<OPTION value="nom"> Nom du client (<%=cli.getNom() %>)
					<OPTION value="prenom"> Prenom du client (<%= cli.getPrenom()%>)
					<OPTION value="adresse"> adresse du client (<%= cli.getAdresse()%>)
					<OPTION value="tel"> Téléphone du client (<%= cli.getTel()%>)
					<OPTION value="mail"> Mail du client (<%= cli.getMail()%>)
					<OPTION value="siret"> Numéro de Siret du Client (<%= cli.getNumSiret()%>)
				</SELECT> 
			</td>
       		<td><i>Veuillez rentrer la valeur du champ Ã  modifier</i></br> <input name="modif" type="text" /></td>
        </tr>
        <tr>
             <td><input type="submit" name="submit"></td>
        </tr>
	</table>
</form>
<br>
<form action="UpdateClient2Servlet" method="POST">
	<table>
<!-- Gestion des sessions -->  
         <tr>
           	<th>Vous voulez ajouter une session Ã  une salle ?</th><input type="HIDDEN" name="idClient" type="number" value="<%= cli.getId()%>">    	
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
           	<th>Vous voulez supprimer la session d'un Client ?</th><input type="HIDDEN" name="idClientRm" type="number" value="<%= cli.getId()%>">
           	<td><i>Voici la liste des sessions qui sont pour l'instant liées à ce Client</i>
            	<SELECT size="1" name="idSessRm">
             		<% for (com.lip6.entities.Session sess:cli.getSessions()){ %>
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