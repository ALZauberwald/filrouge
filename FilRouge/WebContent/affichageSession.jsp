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
	<table>
			
			<tr>          
	            <td><i>Modifier une session dans la base de donnée.</i> 
            </tr>
            <tr>
             	<td><i>Nom Session</i></br> <%= sess.getNomSession() %>  </td>
             	<td><i>Nom Formation</i></br>
             	<%if (sess.getFormation()==null){%>
      				NA
      			<%}else{%>      			
             	<% com.lip6.entities.Formation form=sess.getFormation();%>
   					<%=form.getNomFormation() %>
				<% }%>
	            <td><i>prix</i></br> <%= sess.getPrix() %>  </td>
	            <td><i>dateDebut</i></br> <%= sess.getDateDebut() %> </td>
	            <td><i>dateFin</i></br> <%= sess.getDateFin() %> </td>
	            <td><i>lieu</i></br> <%= sess.getLieu() %>  </td>
				<%if (sess.getSalle()==null){%>
      			<%}else{%>      			
             	<% com.lip6.entities.Salle sa=sess.getSalle();%>
   				</br>Adresse :<%= sa.getAdresse() %>
   				<%} %>
			</tr>
	</table>
	<form action="InscriptionStagiaireServlet" method="POST">
		<table>
			
			<tr>          
	           <h1>Inscrivez-vous!</h1> 
            </tr>
            <tr>
            	<input type="HIDDEN" name="idSession" type="number" value="<%= sess.getIdSession()%>">
               	<td><i>Veuillez rentrer votre nom</i> <input type="text" name="nomStagiaire">  </td>
	            <td><i>Veuillez rentrer votre prénom</i> <input type="text" name="prenomStagiaire">  </td>
	            <td><i>Veuillez rentrer votre adresse</i> <input type="text" name="adresse">  </td>
	            <td><i>Veuillez rentrer votre numéro de téléphone</i> <input type="text" name="tel">  </td>
	            <td><i>Veuillez rentrer votre mail</i> <input type="text" name="mail">  </td>
            </tr>
            
            <tr>
            <td><input type="submit" name="submit"></td>
            </tr>
		</table>
	</form>			
</body>
</html>