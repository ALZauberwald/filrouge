<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styles.css">
<title>Insert title here</title>
</head>
<body>
<header class="cd-main-header">
		<div class="logo">
			<a  href="index.html" title="formation informatique" >
				<img src="./images/it-logo.png" alt="Accueil IT Training" width="100">
			</a>
		</div>
		<div class="topnav">
	  		<a href="index.html">Home</a>
	  		<a href="#formations">Formations</a>
	  		<a href="#contact">Contact</a>
	  		<a href="#client">Espace client</a>
	  		<a href="#quisommenous">Qui sommes-nous</a>
	  		<input type="text" placeholder="Search..">
	  		
	  		<form  action = "accueilAdmin.jsp" method="POST">
				<h2>Connexion admin</h2>
				<table>
			    	<tr>       
			    	    <td><i>Username</i></td><td><input type="text" name="username">  </td>       
			    	</tr>
			    	<tr>       
			        	<td><i>password</i></td><td><input type="password" name="password">  </td>       
			    	</tr>
			    	<tr>
			        	<td><input type="submit" name="submit" value="Connexion">  </td> 
			    	</tr>    
				</table>
			</form>
			
		</div>
</header>
</body>
</html>