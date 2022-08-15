<%@page import="com.lip6.entities.Theme"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="form" scope="request" class="com.lip6.entities.Theme" ></jsp:useBean>
<jsp:useBean id="formationsdisponibles" scope="request" class="java.util.HashSet" ></jsp:useBean>
<jsp:useBean id="themesdisponibles" scope="request" class="java.util.HashSet" ></jsp:useBean>

<body>
 
<form action="UpdateThemeServlet" method="POST">
	<table>		
		<!-- affichage du contenu du theme -->
		<tr>          
	    	<td><i>Modifier un theme dans la base de donnee.</i> 
        </tr>
        <tr>
           	<td><i>Id du theme</i> </br><%= form.getIdTheme() %> </td>
           	<td><i>nom du theme</i> </br><%= form.getNomTheme() %>  </td>  	
            <td><i>formations associée</i>            
           		<% for (com.lip6.entities.Formation formation:form.getFormation()){ %>
   				</br><%= formation.getNomFormation() %> 
				<% } %> 
			</td>
            <td><i>sous themes associés</i>
            <% for (com.lip6.entities.Theme ssTheme:form.getSousthemes()){ %>
   				</br><%= ssTheme.getNomTheme() %> 
				<% } %> 
            </td>         
        </tr>
	
	<!-- affichage des modifications possibles (les champs)-->
           	<td><i>Veuillez choisir le champ à modifier</i>
           		<SELECT name="champAModif" size="1">
					<OPTION value="nom"> Nom du theme (<%= form.getNomTheme()%>)
				</SELECT> 
           	<td><i>Veuillez rentrer la valeur du champ à modifier</i> <input name="modif" type="text" /></td>
      	</tr>
        <tr>
            <td><input type="submit" name="submit"></td>
        </tr>  
	</table>
</form>
<!-- affichage des modifications possibles (les associations)-->
<form action="UpdateTheme2Servlet" method="POST">
	<table>
		<!-- Gestion des formations -->  
        <tr>
           	<th>Vous voulez ajouter une formation à ce theme ?</th><input type="HIDDEN" name="idTheme" type="number" value="<%= form.getIdTheme()%>">    	
            	<td><i>Voici la liste des formations disponibles</i>	
            		<SELECT size="1" name="idFormation">
            			<% for (Object formation:formationsdisponibles){%>
							<OPTION value="<%= formation.toString().split("  |  ")[0]%>"> <%= formation%>	
						<% } %> 
					</SELECT> 
            	</td>
        <tr>
           	<td><button input type="submit" name="choix" value="assoFormation">Ajouter la formation</td>
        </tr> 
           	<th>Vous voulez supprimer une formation de ce theme ?</th><input type="HIDDEN" name="idThemeRm" type="number" value="<%= form.getIdTheme()%>">
           	<td><i>Voici la liste des formations qui sont pour l'instant liÃ©s Ã  ce theme</i>
            	<SELECT size="1" name ="idFormationRm">
            		<% for (com.lip6.entities.Formation formation:form.getFormation()){%>
						<OPTION value="<%= formation.toString().split("  |  ")[0]%>"> <%= formation.getIdFormation()%>  |  <%= formation.getNomFormation()%>
					<% } %> 
				</SELECT> 
           	</td>
            	
         </tr>
         <tr>
           	<td><button input type="submit" name="choix" value="rmFormation">Supprimer la formation</td>
         </tr>
		</br>
		<!-- Gestion des sousthemes -->       
        <tr>
           	<th>Vous voulez ajouter un sous-theme à ce theme ?</th><input type="HIDDEN" name="idTheme" type="number" value="<%= form.getIdTheme()%>">    	
            	<td><i>Voici la liste des themes disponibles</i>	
            		<SELECT size="1" name = "idSoustheme">
            			<% for (Object theme:themesdisponibles){%>
							<OPTION VALUE="<%= theme.toString().split("  |  ")[0]%>"> <%= theme%>	
						<% } %> 
					</SELECT> 
            	</td>
            	
        <tr>
           	<td><button input type="submit" name="choix" value="assoSoustheme">Ajouter le sous-theme</td>
        </tr>     
           	<th>Vous voulez supprimer un sous-theme de ce theme ?</th><input type="HIDDEN" name="idThemeRm" type="number" value="<%= form.getIdTheme()%>">
           	<td><i>Voici la liste des sous-themes qui sont pour l'instant liÃ©s Ã  ce theme</i>
            	<SELECT size="1" name = "idSousthemeRm">
            		<% for (com.lip6.entities.Theme soustheme:form.getSousthemes()){%>
						<OPTION value="<%= soustheme.toString().split("  |  ")[0]%>"> <%= soustheme.getIdTheme()%>  |  <%= soustheme.getNomTheme()%>
					<% } %> 
				</SELECT> 
           	</td>            	
         </tr>
         <tr>
           	<td><button input type="submit" name="choix" value="rmSoustheme">Supprimer le sous-theme</td>
         </tr>
		</br>
	</table>
</form>
</body>
</html>