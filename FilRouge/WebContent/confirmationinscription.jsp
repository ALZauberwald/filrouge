<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<h1>Votre inscription à cette session est validée</h1>
<div class="epais">
<form class="example" action="ClientSearchServlet" method="POST">
  <input type="text" placeholder="Thème, référence, mot clé..." name="search">
  <button type="submit"><i class="fa fa-search"></i></button>
</form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>