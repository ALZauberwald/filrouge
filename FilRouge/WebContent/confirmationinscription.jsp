<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<br>
<h1>Votre inscription � cette session est valid�e</h1>
<div class="epais">
<form class="example" action="ClientSearchServlet" method="POST">
  <input type="text" placeholder="Th�me, r�f�rence, mot cl�..." name="search">
  <button type="submit"><i class="fa fa-search"></i></button>
</form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>