<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="sess" scope="request" class="com.lip6.entities.Session" ></jsp:useBean>
<jsp:useBean id="sallesdisponibles" scope="request" class="java.util.HashSet" ></jsp:useBean>
<body>
 
<form action="UpdateSessionServlet" method="POST">
<table>
			
			<tr>          
	            <td><i>Modifier une session dans la base de donnée.</i> 
            </tr>
            <tr>
            	<td><i>Id Session</i> <%= sess.getIdSession()%></td>
             	<td><i>nomSession</i> <%= sess.getNomSession() %>  </td>
             	<td><i>nomFormation</i> <%= sess.getFormation().getNomFormation() %>  </td>
	            <td><i>prix</i> <%= sess.getPrix() %>  </td>
	            <td><i>dateDebut</i> <%= sess.getDateDebut() %> </td>
	            <td><i>lieu</i> <%= sess.getLieu() %>  </td>
	            <td><i>formateurConfirmé</i> <%= sess.isFormateurConfirme() %>  </td>
	            <td><i>typeSession</i> <%= sess.getTypeSession() %>  </td>
	            <td><i>installationFinie</i> <%= sess.isInstallationFinie() %></td>  
	            <td><i>Salle</i> 
	            <%if (sess.getSalle()==null){%>
      				NA
      		<%}else{%>      			
             	<% com.lip6.entities.Salle sa=sess.getSalle();%>
   				</br>Adresse :<%= sa.getAdresse() %>
   				</br>Nom Salle : <%= sa.getNomSalle() %> 
				<% }%>
   				
			</td>    
	            
             </tr>
            <tr>
            	<td><i>IdSession</i> <input name="idSession" type="number" value="<%= sess.getIdSession()%>"></td>
            	<td><i>Veuillez rentrer le champ à modifier</i> <input name = "champAModif" type ="text" /></td>
            	<td><i>Veuillez rentrer la valeur du champ à modifier</i> <input name="modif" type="text" /></td>
            </tr>
            <tr>
            <td><input type="submit" name="submit"></td>
            </tr>
</table>
</form>
<br>
<form action="UpdateSession2Servlet" method="POST">
	<table>
<!-- Gestion des sessions -->  
         <tr>
           	<th>Vous voulez ajouter une salle à une session ?</th><input type="HIDDEN" name="idSession" type="number" value="<%= sess.getIdSession()%>">    	
            	<td><i>Voici la liste des salles disponibles</i>	
            		<SELECT size="1">
            			<% for (Object salle:sallesdisponibles){%>
            				<OPTION><%= salle %>	
						<% } %> 
					</SELECT> 
            	</td>
            	<td><i>Indiquez simplement le numÃ©ro de la session que vous souhaitez ajouter</i><input name="idSalle" type="number" ></td>
        <tr>
           	<td><button input type="submit" name="choix" value="assoSession">Ajouter la session</td>
        </tr>
           	<th>Vous voulez supprimer la salle d'une session ?</th><input type="HIDDEN" name="idSessRm" type="number" value="<%= sess.getIdSession()%>">
           	<td><i>Voici la liste salle liée à cette session</i>
      		<SELECT size="1">
      		<OPTION value="Salle">
      		<%if (sess.getSalle()==null){%>
      		<br> Aucune salle attitrée
      		<%}else{%>
      			<% com.lip6.entities.Salle sa2=sess.getSalle();%>
				<%= sa2.getIdSalle()%>  |  <%= sa2.getNomSalle() %>
				<% }%>
				</SELECT>	 
           	</td>
           	<td><i>Indiquez simplement le numÃ©ro de la salle que vous souhaitez supprimer</i><input name="idSalleRm" type="number" ></td>
            	
         </tr>
         <tr>
           	<td><button input type="submit" name="choix" value="rmSession">Supprimer la session</td>
         </tr>     
            
	</table>

</form>
</body>
</html>