<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.lip6.entities.Session"%>
<%@page import="com.lip6.entities.Formation"%>
<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<jsp:useBean id="formationsdisponibles" scope = "request" class="java.util.HashSet"></jsp:useBean>
<body>
<%@ include file="headerClient.jsp" %>
<br>
<br>
<br>
<br>
	<div class="retreci">
	<form action="AffichageSessionServlet" method="POST">
		<ul><c:forEach var="formation" items="${requestScope.formationsdisponibles}">
			<%int num = 1;%>
			<table class="table table-hover " id ="afftbl">
  				<caption class="caption-top aligncenter" >Formation : <c:out value="${formation.getNomFormation()}" /></caption>
					 				<thead>
					 					<tr class="table-info">
					 						<th scope="col" id="afftd">#</th>	
						 					<th scope="col" id="afftd">Session</th>
						 					<th scope="col" id="afftd">Prix</th>
						 					<th scope="col" id="afftd">Date de Début</th>
						 					<th scope="col" id="afftd">Date de Fin</th>
						 					<th scope="col" id="afftd">Ville</th>
						 					<th scope="col" id="afftd">Lien vers la session</th>
					 					</tr>
					 				</thead>
					 				</tbody>
									<c:forEach var="sess" items="${formation.getSessions()}">	
						 				<tr >
						 					<th scope="row" id="afftd"><% out.println(num++);  %></th>
							 				<td id="afftd"><c:out value="${sess.getNomSession()}"/></td>
							 				<td id="afftd"><c:out value="${sess.getPrix()}"/></td>
							 				<td id="afftd"><c:out value="${sess.getDateDebut()}"/></td>
							 				<td id="afftd"><c:out value="${sess.getDateFin()}"/></td>
							 				<td id="afftd"><c:out value="${sess.getLieu()}"/></td>
							 				<td id="afftd"><button  type="submit" name="idSession" value="${sess.getIdSession()}">Cliquez ici</button></td>
						 				</tr>
					 				</c:forEach>
					 				</tbody>		 				
					 			</table>
					
				
			</c:forEach>
		</ul>	
	</form>
	</div>
	<div class="retreci">
	<div class="epais">
		<form class="example" action="ClientSearchServlet" method="POST">
	  		<input type="text" placeholder="Thème, référence, mot clé..." name="search">
	  		<button type="submit"><i class="fa fa-search"></i></button>
		</form>
		<div class="decal">
		<%if(formationsdisponibles.isEmpty()){ %>
			<h5 >Aucune formation ne correspond à votre recherche, veuillez entrer une nouvelle recherche</h5>
		<%} %>
		</div>
			 
		</div>	
	</div>	
<%@include file="footer.jsp" %>
</body>
</html>
