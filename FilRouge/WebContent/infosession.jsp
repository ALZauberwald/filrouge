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
<jsp:useBean id="formationsdisponibles" scope="request" class="java.util.HashSet" ></jsp:useBean>
<jsp:useBean id="formateursdisponibles" scope="request" class="java.util.HashSet" ></jsp:useBean>
<jsp:useBean id="clientsdisponibles" scope="request" class="java.util.HashSet" ></jsp:useBean>
<jsp:useBean id="stagiairesdisponibles" scope="request" class="java.util.HashSet" ></jsp:useBean>
<body>
 
<form action="UpdateSessionServlet" method="POST">
<table>
			
			<tr>          
	            <td><i>Modifier une session dans la base de donnée.</i> 
            </tr>
            <tr>
            	<td><i>Id Session</i> <%= sess.getIdSession()%></td>
             	<td><i>nomSession</i> <%= sess.getNomSession() %>  </td>
             	<td><i>Nom Formation</i>
             	<%if (sess.getFormation()==null){%>
      				NA
      			<%}else{%>      			
             	<% com.lip6.entities.Formation form=sess.getFormation();%>
   					<%=form.getNomFormation() %>
				<% }%>
	            <td><i>prix</i> <%= sess.getPrix() %>  </td>
	            <td><i>dateDebut</i> <%= sess.getDateDebut() %> </td>
	            <td><i>lieu</i> <%= sess.getLieu() %>  </td>
	            <td><i>formateurConfirmé</i> <%= sess.isFormateurConfirme() %>  </td>
	            <td><i>Formateur</i>
	            <%if (sess.getFormateur()==null){%>
      				NA
      			<%}else{%>      			
             	<% com.lip6.entities.Formateur form=sess.getFormateur();%>
   					<%=form.getNom() %> <%=form.getPrenom()%>
				<% }%>
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
				<td><i>Stagiaires</i> 
             	<% for (com.lip6.entities.Stagiaire st:sess.getStagiaires()){ %>
   				</br><%= st.getNom() %> <%=st.getPrenom() %>
				<% } %>   
				</td>
				<td><i>Clients</i> 
             	<% for (com.lip6.entities.Client cl:sess.getClient()){ %>
   				</br><%= cl.getNom() %> <%=cl.getPrenom() %>
				<% } %>   
				</td>
				
   				
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
<!-- Gestion des salles -->  
         <tr>
           	<th>Vous voulez ajouter une salle à une session ?</th><input type="HIDDEN" name="idSession" type="number" value="<%= sess.getIdSession()%>">    	
            	<td><i>Voici la liste des salles disponibles</i>	
            		<SELECT size="1" name="idSalle">
            			<% for (Object salle:sallesdisponibles){%>
            				<OPTION VALUE="<%= salle.toString().split("  |  ")[0]%>"><%= salle %>	
						<% } %> 
					</SELECT> 
            	</td>
        <tr>
           	<td><button input type="submit" name="choix" value="assoSalle">Ajouter la salle</td>
        </tr>
           	<th>Vous voulez supprimer la salle d'une session ?</th><input type="HIDDEN" name="idSessRm" type="number" value="<%= sess.getIdSession()%>">
           	<td><i>Voici la salle liée à cette session</i>
      		<SELECT size="1" name="idSalleRm">
      		<%if (sess.getSalle()==null){%>
      		<br> Aucune salle attitrée
      		<%}else{%>
      			<% com.lip6.entities.Salle sa2=sess.getSalle();%>
				<OPTION value="<%= sa2.toString().split("  |  ")[0]%>"><%= sa2.getIdSalle()%>  |  <%= sa2.getNomSalle() %>
				<% }%>
				</SELECT>	 
           	</td>
            	
         </tr>
         <tr>
           	<td><button input type="submit" name="choix" value="rmSalle">Supprimer la salle</td>
         </tr> 
<!-- Gestion des formations -->      
         <tr>
           	<th>Vous voulez ajouter une formation à une session ?</th><input type="HIDDEN" name="idSession" type="number" value="<%= sess.getIdSession()%>">    	
            	<td><i>Voici la liste des formations disponibles</i>	
            		<SELECT size="1" name="idFormation">
            			<% for (Object form:formationsdisponibles){%>
            				<OPTION VALUE="<%= form.toString().split("  |  ")[0]%>"><%= form %>	
						<% } %> 
					</SELECT> 
            	</td>
        <tr>
           	<td><button input type="submit" name="choix" value="assoFormation">Ajouter la session</td>
        </tr>
           	<th>Vous voulez supprimer la formation d'une session ?</th><input type="HIDDEN" name="idSessRm" type="number" value="<%= sess.getIdSession()%>">
           	<td><i>Voici la liste des formations liées à cette session</i>
      		<SELECT size="1" name="idFormationRm">
      		<%if (sess.getFormation()==null){%>
      		<br> Aucune formation attitrée
      		<%}else{%>
      			<% com.lip6.entities.Formation form2=sess.getFormation();%>
				<OPTION value="<%= form2.toString().split("  |  ")[0]%>"><%= form2.getIdFormation()%>  |  <%= form2.getNomFormation() %>
				<% }%>
				</SELECT>	 
           	</td>
            	
         </tr>
         <tr>
           	<td><button input type="submit" name="choix" value="rmFormation">Supprimer la formation</td>
         </tr> 
 <!-- Gestion des formateurs -->      
         <tr>
           	<th>Vous voulez ajouter un formateur à une session ?</th><input type="HIDDEN" name="idSession" type="number" value="<%= sess.getIdSession()%>">    	
            	<td><i>Voici la liste des formateurs disponibles</i>	
            		<SELECT size="1" name="idFormateur">
            			<% for (Object form:formateursdisponibles){%>
            				<OPTION VALUE="<%= form.toString().split("  |  ")[0]%>"><%= form %>	
						<% } %> 
					</SELECT> 
            	</td>
        <tr>
           	<td><button input type="submit" name="choix" value="assoFormateur">Ajouter le formateur</td>
        </tr>
           	<th>Vous voulez supprimer le formateur d'une session ?</th><input type="HIDDEN" name="idSessRm" type="number" value="<%= sess.getIdSession()%>">
           	<td><i>Voici la liste des formations liées à cette session</i>
      		<SELECT size="1" name="idFormateurRm">
      		<%if (sess.getFormateur()==null){%>
      		<br> Aucune formateur attitré
      		<%}else{%>
      			<% com.lip6.entities.Formateur form2=sess.getFormateur();%>
				<OPTION value="<%= form2.toString().split("  |  ")[0]%>"><%= form2.getId() %>  |  <%=form2.getNom() %>
				<% }%>
				</SELECT>	 
           	</td>
            	
         </tr>
         <tr>
           	<td><button input type="submit" name="choix" value="rmFormateur">Supprimer le formateur</td>
         </tr>   
<!-- Gestion des Stagiaires -->  
         <tr>
           	<th>Vous voulez ajouter un stagiaire à une session ?</th><input type="HIDDEN" name="idSession" type="number" value="<%= sess.getIdSession()%>">    	
            	<td><i>Voici la liste des stagiaires disponibles</i>	
            		<SELECT size="1" name="idStagiaire">
            			<% for (Object st:stagiairesdisponibles){ %>
   						</br><OPTION VALUE="<%= st.toString().split("  |  ")[0]%>"><%= st%>
						<% } %> 
					</SELECT> 
            	</td>
        <tr>
           	<td><button input type="submit" name="choix" value="assoStagiaire">Ajouter le stagiaire</td>
        </tr>
           	<th>Vous voulez supprimer le stagiaire d'une session ?</th><input type="HIDDEN" name="idSessRm" type="number" value="<%= sess.getIdSession()%>">
           	<td><i>Voici la liste des formations liées à cette session</i>
      			<SELECT size="1" name="idStagiaireRm">
      				<% for (com.lip6.entities.Stagiaire st:sess.getStagiaires()){ %>
   					<OPTION value="<%= st.toString().split("  |  ")[0]%>"><%= st.getId() %>  |  <%=st.getNom() %>
					<% } %>
				</SELECT>	 
           	</td>
            	
         </tr>
         <tr>
           	<td><button input type="submit" name="choix" value="rmStagiaire">Supprimer le stagiaire</td>
         </tr> 
<!-- Gestion des Clients -->     
         <tr>
           	<th>Vous voulez ajouter un client à une session ?</th><input type="HIDDEN" name="idSession" type="number" value="<%= sess.getIdSession()%>">    	
            	<td><i>Voici la liste des clients disponibles</i>	
            		<SELECT size="1" name="idClient">
            			<% for (Object client:clientsdisponibles){%>
            				<OPTION VALUE="<%= client.toString().split("  |  ")[0]%>"><%= client %>	
						<% } %> 
					</SELECT> 
            	</td>
        <tr>
           	<td><button input type="submit" name="choix" value="assoClient">Ajouter la session</td>
        </tr>
           	<th>Vous voulez supprimer un client d'une session ?</th><input type="HIDDEN" name="idSessRm" type="number" value="<%= sess.getIdSession()%>">
           	<td><i>Voici la liste des client liées à cette session</i>
      		<SELECT size="1" name="idClientRm">
      		
      			<% for (com.lip6.entities.Client cl:sess.getClient()){ %>
   					<OPTION value="<%= cl.toString().split("  |  ")[0]%>"><%= cl.getId() %>  |  <%=cl.getNom() %>
				<% } %>
				</SELECT>	 
           	</td>
            	
         </tr>
         <tr>
           	<td><button input type="submit" name="choix" value="rmClient">Supprimer la session</td>
         </tr>
            
	</table>

</form>
</body>
</html>