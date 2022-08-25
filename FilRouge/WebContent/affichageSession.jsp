<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styles.css">
<title>Insert title here</title>
</head>
<jsp:useBean id="sess" scope="request" class="com.lip6.entities.Session" ></jsp:useBean>
<body>
<%@ include file="headerClient.jsp" %>
<br><br><br><br>
	<table>
				<h1><%=sess.getNomSession() %>	</h1>
			
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
<%@include file="footer.jsp" %>		
</body>
</html>