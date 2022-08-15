<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="stag" scope="request" class="com.lip6.entities.Stagiaire" ></jsp:useBean>
<body>
<form action="UpdateStagiaireServlet" method="POST">
	<table>
		<tr>
			<td><i>Id Stagiaire</i></br> <%=stag.getId() %></td>
			<td><i>Nom</i></br> <%=stag.getNom() %>  </td>
			<td><i>Prenom</i></br> <%=stag.getPrenom() %></td>
			<td><i>Adresse</i></br> <%=stag.getAdresse() %> </td>
			<td><i>Tel</i></br><%=stag.getTel() %> </td>
			<td><i>Mail</i></br> <%=stag.getMail()%></td>
			<td><i>Sessions</i> 
             	<% for (com.lip6.entities.Session ses:stag.getSessions()){ %>
   				</br><%= ses.getNomSession() %> 
				<% } %>   
			</td> 
		</tr>
		<tr>
        	<h2>Pour modifier un champ</h2>
           	<td><i>Stagiaire n°=<%= stag.getId()%></i></td>
           	<td><i><%=stag.getNom()%></i><input type="HIDDEN" name="nom" type="text" value="<%= stag.getNom()%>"></td>
           	<td><i><%=stag.getPrenom() %></i><input type="HIDDEN" name="prenom" type="text" value="<%= stag.getPrenom()%>"> </i></td>
           	
           	<td><i>Veuillez choisir le champ Ã  modifier</i>
           		<SELECT name="champAModif" size="1">
					<OPTION value="nom"> Nom du stagiaire (<%=stag.getNom() %>)
					<OPTION value="prenom"> Prenom du stagiaire (<%= stag.getPrenom()%>)
					<OPTION value="adresse"> adresse du stagiaire (<%= stag.getAdresse()%>)
					<OPTION value="tel"> Téléphone du stagiaire (<%= stag.getTel()%>)
					<OPTION value="mail"> Mail du stagiaire (<%= stag.getMail()%>)
					
				</SELECT> 
       		<td><i>Veuillez rentrer la valeur du champ Ã  modifier</i> <input name="modif" type="text" /></td>
        </tr>
        <tr>
             <td><input type="submit" name="submit"></td>
        </tr>
	</table>
</form>
<br>
</body>
</html>