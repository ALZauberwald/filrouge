<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="form" scope="request" class="com.lip6.entities.Formateur" ></jsp:useBean>
<jsp:useBean id="sessionsdisponibles" scope="request" class="java.util.HashSet"></jsp:useBean>
<body>
<%@ include file="header.jsp" %>
	<br>
	<br>
	<br>
	<br>
<form action="UpdateFormateurServlet" method="POST">
	<table>
		<tr>
			<td><i>Id formateur</i><br> <%=form.getId() %></td>
			<td><i>Nom</i><br> <%=form.getNom() %>  </td>
			<td><i>Prenom</i><br> <%=form.getPrenom() %></td>
			<td><i>Adresse</i><br> <%=form.getAdresse() %> </td>
			<td><i>Tel</i><br><%=form.getTel() %> </td>
			<td><i>Mail</i><br> <%=form.getMail()%></td>
			<td><i>Date Embauche</i><br> <%=form.getDateEmbauche() %></td>
			<td><i>Sessions</i> 
             	<% for (com.lip6.entities.Session ses:form.getSessions()){ %>
   				</br><%= ses.getNomSession() %> 
				<% } %>   
			</td> 
		</tr>
		<tr>
        	<h2>Pour modifier un champ</h2>
           	
           	<input type="HIDDEN" name="idFormateur" type="number" value="<%= form.getId()%>">
           	
           	<td><i>Veuillez choisir le champ Ã  modifier</i></br>
           		<SELECT name="champAModif" size="1">
					<OPTION value="nom"> Nom du formateur (<%=form.getNom() %>)
					<OPTION value="prenom"> Prenom du formateur (<%= form.getPrenom()%>)
					<OPTION value="adresse"> adresse du formateur (<%= form.getAdresse()%>)
					<OPTION value="tel"> Téléphone du formateur (<%= form.getTel()%>)
					<OPTION value="mail"> Mail du formateur (<%= form.getMail()%>)
					<OPTION value="embauche"> Date d'embauche du formateur (<%= form.getDateEmbauche()%>)
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
<form action="UpdateFormateur2Servlet" method="POST">
	<table>
<!-- Gestion des sessions -->  
         <tr>
           	<th>Vous voulez ajouter une session Ã  une salle ?</th><input type="HIDDEN" name="idFormateur" type="number" value="<%= form.getId()%>">    	
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
           	<th>Vous voulez supprimer la session d'un Formateur ?</th><input type="HIDDEN" name="idFormateurRm" type="number" value="<%= form.getId()%>">
           	<td><i>Voici la liste des sessions qui sont pour l'instant liées à ce Formateur</i>
            	<SELECT size="1" name="idSessRm">
             		<% for (com.lip6.entities.Session sess:form.getSessions()){ %>
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