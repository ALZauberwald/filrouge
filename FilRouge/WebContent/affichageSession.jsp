<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styles.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<jsp:useBean id="sess" scope="request" class="com.lip6.entities.Session" ></jsp:useBean>
<body>
<%@ include file="headerClient.jsp" %>
<br><br><br><br>
	<table class="table table-sm caption-top">
				<caption><%=sess.getNomSession() %></caption>
            <tr class="table-info">
             	<td>Nom Formation</td>
      			<td>prix</td>
	            <td>dateDebut</td>
	            <td>dateFin</td>
	            <td>lieu</td>
	            <td>Adresse</td>
			</tr>
			<tr>
				<td><%if (sess.getFormation()==null){%>
      				NA
      			<%}else{%>      			
             	<% com.lip6.entities.Formation form=sess.getFormation();%>
   					<%=form.getNomFormation() %>
				<% }%>
				</td>
				<td><%= sess.getPrix() %></td>
				<td> <%= sess.getDateDebut() %></td>
				<td>  <%= sess.getDateFin() %> </td>
				<td>   <%= sess.getLieu() %> </td>
				<td> <%if (sess.getSalle()==null){%>
      				<%}else{%>      			
             		<% com.lip6.entities.Salle sa=sess.getSalle();%>
   					<%= sa.getAdresse() %>
   					<%} %>
   				</td>
			</tr>
	</table>
	<div class="divRep">
		<div class=infoForm>	
			<div>	
				<h2>Détails de la formation</h2>
				<%=sess.getFormation().getDetailFormation() %>
			</div>
			<div>
				<h2>Objectifs de la formation</h2>
				<ul class="list-group list-group-flush">
				<c:set var="session" value="${requestScope.sess}"/>
					 <c:forEach var="form" items="${session.getFormation().getObjectifsFormation()}">
					 <li class="list-group-item"><c:out value="${form.getNomObjectif()}"/></li>
					 </c:forEach>
				</ul>
			</div>
			<div>
				<h2>Prerequis de la formation</h2>
				<ul class="list-group list-group-flush">
				<c:set var="session" value="${requestScope.sess}"/>
					 <c:forEach var="form" items="${session.getFormation().getPrerequisFormation()}">
					 <li class="list-group-item"><c:out value="${form.getNomPrerequis()}"/></li>
					 </c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<div class="divRep">
		<div class="moitie" >
			<form action="InscriptionStagiaireServlet" method="POST">
				<caption "caption-top"><h1>Inscription</h1></caption>
				<div class="mb-3 insc" >
		  			<label for="nomStagiaire" class="form-label">Nom</label>
		  			<input type="text" class="form-control" id="nomStagiaire" name="nomStagiaire" placeholder="Nom">
				</div>
				<div class="mb-3 insc" >
		  			<label for="prenomStagiaire" class="form-label">Prenom</label>
		  			<input type="text" class="form-control" id="prenomStagiaire" name="prenomStagiaire" placeholder="Prenom">
				</div>
				<div class="mb-3 insc">
		  			<label for="adresse" class="form-label">Adresse</label>
		  			<input type="text" class="form-control" id="adresse" name="adresse" placeholder="Adresse">
				</div>
				<div class="mb-3 insc">
		  			<label for="tel" class="form-label">Telephone</label>
		  			<input type="text" class="form-control" id="tel" name="tel" placeholder="rentrez votre n° de telephone">
				</div>
				<div class="mb-3 insc">
		  			<label for="mail" class="form-label">Adresse mail</label>
		  			<input type="text" class="form-control" id="mail" name="mail" placeholder="example@example.com">
				</div>
				<input type="HIDDEN" name="idSession" type="number" value="<%= sess.getIdSession()%>">
				<% String mail = request.getParameter("mail");%>
		        <div ><a href="mailto:producodagejavajeremy88@yopmail.com" target="_blank" value="test"><button type="submit" name="submit" class="btn btn-success btn-lg pull-right">Submit</button></a></div>
		        <div><br></div>
			</form>	
		</div>
	</div>
<%@include file="footer.jsp" %>		
</body>
</html>