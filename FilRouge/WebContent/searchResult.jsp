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
<title>Insert title here</title>
</head>
<body>
<%@ include file="headerClient.jsp" %>

<br>
<br>
<br>
<br>
	<form action="AffichageSessionServlet" method="POST">
		<ul><c:forEach var="formation" items="${requestScope.formationsdisponibles}">
		
				<li ><c:out value="${formation.getNomFormation()}" /></a>
					<c:forEach var="sess" items="${formation.getSessions()}">
					 	<ul >
					 		<li>	
					 				<c:out value="${sess.getNomSession()}"/>
					 				<c:out value="${sess.getPrix()}"/>
					 				<c:out value="${sess.getDateDebut()}"/>
					 				<c:out value="${sess.getDateFin()}"/>
					 				<c:out value="${sess.getIdSession()}"/>
					 				<button type="submit" name="idSession" value="${sess.getIdSession()}">Choose</button>
					 		</li>
					 	</ul>
					</c:forEach>
				</li>
			</c:forEach>
		</ul>	
	</form>
	<div class="epais">
		<form class="example" action="ClientSearchServlet" method="POST">
	  		<input type="text" placeholder="Thème, référence, mot clé..." name="search">
	  		<button type="submit"><i class="fa fa-search"></i></button>
		</form>
	</div>	
<%@include file="footer.jsp" %>
</body>
</html>
