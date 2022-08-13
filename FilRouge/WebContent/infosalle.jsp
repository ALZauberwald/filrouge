<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="salle" scope="request" class="com.lip6.entities.Salle" ></jsp:useBean>
<body>
<form action="UpdateSalleServlet" method="POST">
	<table>
		<tr>
			<td><i>Id Salle</i> <input type="number" name="idSalle" value="<%= salle.getIdSalle()%>"></td>
			<td><i>Adresse</i> <input type="text" name="adresse" value="<%=salle.getAdresse()%>">  </td>
			<td><i>Nom Salle</i> <input type="text" name="nomSalle" value="<%=salle.getNomSalle()%>">  </td>
		</tr>
		<tr>
	            <td><input type="submit" name="submit"></td>
	    </tr>
	</table>
</form>
</body>
</html>