<%@page import="com.lip6.entities.Prerequis"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styles.css">
<title>Insert title here</title>
</head>
<jsp:useBean id="form" scope="request" class="com.lip6.entities.Chapitre" ></jsp:useBean>
<jsp:useBean id="formationsdisponibles" scope="request" class="java.util.HashSet" ></jsp:useBean>
<body>
 <%@ include file="header.jsp" %>
	<br>
	<br>
	<br>
	<br>
<form action="UpdateChapitreServlet" method="POST">
	<table>		
		<tr>          
           <td><i>Modifier un Chapitre dans la base de donnée.</i> 
        </tr>
        <tr>
        	<td><i>Id Chapitre</i> <%= form.getIdChapitre() %> </td>
         	<td><i>Nom du Chapitre</i> <%= form.getNomChapitre() %>  </td>
         	<td><i>Durée du Chapitre</i> <%= form.getDureeChapitre()%>  </td>
         	<td><i>Détail du Chapitre</i> <%= form.getDetailChapitre() %>  </td>
      
         	 <td><i>formation à laquelle ce chapitre est rattaché </i></br>  
         	 <% if(form.getFormation()==null){%>
         	Pas de formation associ�e<%}else{%>
         	 <%com.lip6.entities.Formation fm =form.getFormation();%>
         	 <%=fm.getNomFormation()%>
         	 <%}%></td>   


           	
           	
           	
        <tr>
           	<td> <input  type ="hidden" name="idChapitre" type="number" value="<%= form.getIdChapitre() %>"></td>
           	<td><i>Veuillez choisir le champ à modifier</i>
           		<SELECT name="champAModif" size="1">
					<OPTION value="nom"> Nom du Chapitre (<%= form.getNomChapitre()%>)
					<OPTION value="duree"> Durée du Chapitre (<%= form.getDureeChapitre()%>)
					<OPTION value="detail"> Détail du Chapitre (<%= form.getDetailChapitre()%>)
				</SELECT> 
           	<td><i>Veuillez rentrer la valeur du champ à modifier</i> <input name="modif" type="text" /></td>
      	</tr>
        <tr>
            <td><input type="submit" name="submit"></td>
        </tr>
	</table>
</form>


<!-- affichage des modifications possibles (les associations)-->
<form action="UpdateChapitre2Servlet" method="POST">
	<table>
		<!-- Gestion des formations -->  
        <tr>
           	<th>Vous voulez changer la formation associee � ce chapitre ?</th><input type="HIDDEN" name="idChapitre" type="number" value="<%= form.getIdChapitre()%>">    	
            	<td><i>Voici la liste des formations disponibles</i>	
            		<SELECT size="1" name ="idFormation">
            			<% for (Object formation:formationsdisponibles){%>
							<OPTION value ="<%= formation.toString().split("  |  ")[0]%>"> <%= formation%>	
						<% } %> 
					</SELECT> 
            	</td>
            	
        </tr>
        <tr>
           	<td><button input type="submit" name="choix" value="assoFormation">Ajouter la formation</td>
        </tr>
        <tr>
           	<th>Vous voulez supprimer une formation de ce chapitre ?</th><input type="HIDDEN" name="idChapitreRm" type="number" value="<%= form.getIdChapitre()%>">
           	<td><i>Voici la formation qui est pour l'instant li�e à ce chapitre</i>
            	 <SELECT size="1" name ="idFormationRm">	
						 <OPTION value="<%= form.toString().split("  |  ")[0]%>"> 
						 <% if(form.getFormation()==null){%>
						 <%}else{%>
						 <%com.lip6.entities.Formation fm =form.getFormation();%>
						 <%= fm.getIdFormation()%>  |  <%= fm.getNomFormation()%> 
						 <%}%>
				</SELECT>  
           	</td>        	
       </tr>
       <tr>
           	<td><button input type="submit" name="choix" value="rmFormation">Supprimer la formation</td>
       </tr> 
		</br>
	</table>
</form>
<%@include file="footer.jsp" %>
</body>
</html>