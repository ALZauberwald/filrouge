<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="form" scope="request" class="com.lip6.entities.Formateur" ></jsp:useBean>
<body>
<form action="UpdateFormateurServlet" method="POST">
	<table>
		<tr>
			<td><i>Id formateur</i><br></br> <%=form.getId() %></td>
			<td><i>Nom</i><br></br> <%=form.getNom() %>  </td>
			<td><i>Prenom</i><br></br> <%=form.getPrenom() %></td>
			<td><i>Adresse</i><br></br> <%=form.getAdresse() %> </td>
			<td><i>Tel</i><br></br><%=form.getTel() %> </td>
			<td><i>Mail</i><br></br> <%=form.getMail()%></td>
			<td><i>Date Embauche</i><br></br> <%=form.getDateEmbauche() %></td>
			<td><i>Sessions</i> 
             	<% for (com.lip6.entities.Session ses:form.getSessions()){ %>
   				</br><%= ses.getNomSession() %> 
				<% } %>   
			</td> 
		</tr>
		<tr>
        	<h2>Pour modifier un champ</h2>
           	<td><i>formateur n°=<%= form.getId()%></i></td>
           	<td><i><%=form.getNom()%></i><input type="HIDDEN" name="nom" type="text" value="<%= form.getNom()%>"></td>
           	<td><i><%=form.getPrenom() %></i><input type="HIDDEN" name="prenom" type="text" value="<%= form.getPrenom()%>"> </i></td>
           	
           	<td><i>Veuillez choisir le champ Ã  modifier</i>
           		<SELECT name="champAModif" size="1">
					<OPTION value="nom"> Nom du formateur (<%=form.getNom() %>)
					<OPTION value="prenom"> Prenom du formateur (<%= form.getPrenom()%>)
					<OPTION value="adresse"> adresse du formateur (<%= form.getAdresse()%>)
					<OPTION value="tel"> Téléphone du formateur (<%= form.getTel()%>)
					<OPTION value="mail"> Mail du formateur (<%= form.getMail()%>)
					<OPTION value="embauche"> Numéro de Siret du formateur (<%= form.getDateEmbauche()%>)
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