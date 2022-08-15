<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="cli" scope="request" class="com.lip6.entities.Client" ></jsp:useBean>
<body>
<form action="UpdateClientServlet" method="POST">
	<table>
		<tr>
			<td><i>Id client</i></br> <%=cli.getId() %></td>
			<td><i>Nom</i></br> <%=cli.getNom() %>  </td>
			<td><i>Prenom</i></br> <%=cli.getPrenom() %></td>
			<td><i>Adresse</i></br> <%=cli.getAdresse() %> </td>
			<td><i>Tel</i></br><%=cli.getTel() %> </td>
			<td><i>Mail</i></br> <%=cli.getMail()%></td>
			<td><i></i></br> <%=cli.getNumSiret() %></td>
			<td><i>Sessions</i> 
             	<% for (com.lip6.entities.Session ses:cli.getSessions()){ %>
   				</br><%= ses.getNomSession() %> 
				<% } %>   
			</td> 
		</tr>
		<tr>
        	<h2>Pour modifier un champ</h2>
           	<td><i>client n�=<%= cli.getId()%></i></td>
           	<td><i><%=cli.getNom()%></i><input type="HIDDEN" name="nom" type="text" value="<%= cli.getNom()%>"></td>
           	<td><i><%=cli.getPrenom() %></i><input type="HIDDEN" name="prenom" type="text" value="<%= cli.getPrenom()%>"> </i></td>
           	
           	<td><i>Veuillez choisir le champ à modifier</i>
           		<SELECT name="champAModif" size="1">
					<OPTION value="nom"> Nom du client (<%=cli.getNom() %>)
					<OPTION value="prenom"> Prenom du client (<%= cli.getPrenom()%>)
					<OPTION value="adresse"> adresse du client (<%= cli.getAdresse()%>)
					<OPTION value="tel"> T�l�phone du client (<%= cli.getTel()%>)
					<OPTION value="mail"> Mail du client (<%= cli.getMail()%>)
					<OPTION value="siret"> Num�ro de Siret du Client (<%= cli.getNumSiret()%>)
				</SELECT> 
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