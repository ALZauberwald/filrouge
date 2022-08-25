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
<%@ include file="header.jsp" %>
	<br>
	<br>
	<br>
	<br>
<form action="UpdateSessionServlet" method="POST">
	<table id ="afftbl"><caption>Voici le contenu de la session selectionnee<br></caption>
		<tr>
        	<td id ="afftd">Id Session</td>
        	<td id ="afftd">Nom Session</td>
        	<td id ="afftd">Formations</td>
        	<td id ="afftd">Prix</td>
        	<td id ="afftd">Date debut</td>
        	<td id ="afftd">Date fin</td>
        	<td id ="afftd">Lieu</td>  
        	<td id ="afftd">Formateur confirme</td>
        	<td id ="afftd">Formateur</td>
        	<td id ="afftd">Type session</td>
        	<td id ="afftd">Installation terminee</td> 
        	<td id ="afftd">Salle</td> 
        	<td id ="afftd">Stagiaire</td>   
        	<td id ="afftd">Clients</td>  	
        </tr>
		 <tr id="afftr">
            	<td id= "afftd"> <%= sess.getIdSession()%></td>
             	<td id= "afftd"> <%= sess.getNomSession() %>  </td>
             	<td id= "afftd">
	             	<%if (sess.getFormation()==null){%>
	      				NA
	      			<%}else{%>      			
	             	<% com.lip6.entities.Formation form=sess.getFormation();%>
	   					<%=form.getNomFormation() %>
					<% }%>
				</td>
	            <td id= "afftd"> <%= sess.getPrix() %>  </td>
	            <td id= "afftd"> <%= sess.getDateDebut() %> </td>
	            <td id= "afftd"> <%= sess.getDateFin() %> </td>
	            <td id= "afftd"> <%= sess.getLieu() %>  </td>
	            <td id= "afftd"> <%= sess.isFormateurConfirme() %>  </td>
	            <td id= "afftd">
		            <%if (sess.getFormateur()==null){%>
	      				NA
	      			<%}else{%>      			
	             	<% com.lip6.entities.Formateur form=sess.getFormateur();%>
	   					<%=form.getNom() %> <%=form.getPrenom()%>
					<% }%>
				</td>
	            <td id= "afftd"> <%= sess.getTypeSession() %>  </td>
	            <td id= "afftd"> <%= sess.isInstallationFinie() %></td>  
	            <td id= "afftd"> 
		            <%if (sess.getSalle()==null){%>
	      				</br>NA
	      			<%}else{%>      			
	             	<% com.lip6.entities.Salle sa=sess.getSalle();%>
	   				</br>Adresse :<%= sa.getAdresse() %>
	   				</br>Nom Salle : <%= sa.getNomSalle() %> 
					<% }%>
				</td>
				<td id= "afftd">
             		<% for (com.lip6.entities.Stagiaire st:sess.getStagiaires()){ %>
	   				</br><%= st.getNom() %> <%=st.getPrenom() %>
					<% } %>   
				</td>
				<td id= "afftd">
	             	<% for (com.lip6.entities.Client cl:sess.getClient()){ %>
	   				</br><%= cl.getNom() %> <%=cl.getPrenom() %>
					<% } %>   
				</td>	            
            </tr>
            <tr>
             	<th>Vous pouvez modifier un champ</th>
            		<input name="idSession" type="hidden" type="number" value="<%= sess.getIdSession()%>">
            	<td><i>Veuillez rentrer le champ à modifier</i></br>
	            	<SELECT name="champAModif" size="1">
						<OPTION value="nomSession"> Nom de la session (<%= sess.getNomSession()%>)
						<OPTION value="prix"> Prix de la session (<%= sess.getPrix()%>)
						<OPTION value="dateDebut"> Date de début de la session (<%= sess.getDateDebut()%>)
						<OPTION value="dateFin"> Date de fin de la session (<%= sess.getDateFin()%>)
						<OPTION value="lieu"> Ville de la session (<%= sess.getLieu()%>)
						<OPTION value="formateurConfirme"> Status formateur de la session (<%= sess.isFormateurConfirme()%>)
						<OPTION value="typeSession"> Type de session (<%= sess.getTypeSession()%>)
						<OPTION value="installationFinie"> Status installation session (<%= sess.isInstallationFinie()%>)
					</SELECT>  
				</td>
            	<td><i>Veuillez rentrer la valeur du champ à modifier</i> <input name="modif" type="text" /></td>
            <td><input type="submit" name="submit"></td>
            </tr>
	</table>
</form>

<form action="UpdateSession2Servlet" method="POST">
	<table id="afftbl"> <caption>Vous pouvez modifier une association<br></caption>
		<tr>
			<td id="afftd">avec</td>
			<td id="afftd">Ajouter</td>
			<td id="afftd">Supprimer</td>
		</tr>
<!-- Gestion des salles -->  
         <tr>
           	<th id="afftd">Une salle</th>  	
           	<td id="afftd">
           		<input type="HIDDEN" name="idSession" type="number" value="<%= sess.getIdSession()%>">  
           		<SELECT size="1" name="idSalle">
           			<% for (Object salle:sallesdisponibles){%>
           				<OPTION VALUE="<%= salle.toString().split("  |  ")[0]%>"><%= salle %>	
					<% } %> 
				</SELECT> 
           		<br><button input type="submit" name="choix" value="assoSalle">Ajouter la salle
           </td>
  			<td id="afftd">
           		<input type="HIDDEN" name="idSessRm" type="number" value="<%= sess.getIdSession()%>">
	      		<SELECT size="1" name="idSalleRm">
		      		<%if (sess.getSalle()==null){%>
		      		<br> Aucune salle attitrée
		      		<%}else{%>
	      			<% com.lip6.entities.Salle sa2=sess.getSalle();%>
					<OPTION value="<%= sa2.toString().split("  |  ")[0]%>"><%= sa2.getIdSalle()%>  |  <%= sa2.getNomSalle() %>
					<% }%>
				</SELECT>	 
           		<br><button input type="submit" name="choix" value="rmSalle">Supprimer la salle
           	</td>
         </tr> 
<!-- Gestion des formations -->      
         <tr>
           	<th id="afftd">Une formation</th>
           	<td id="afftd">
           		<input type="HIDDEN" name="idSession" type="number" value="<%= sess.getIdSession()%>">    	
           		<SELECT size="1" name="idFormation">
           			<% for (Object form:formationsdisponibles){%>
           				<OPTION VALUE="<%= form.toString().split("  |  ")[0]%>"><%= form %>	
					<% } %> 
				</SELECT> 
           		<br><button input type="submit" name="choix" value="assoFormation">Ajouter la formation
           </td>
        	<td>
           		<input type="HIDDEN" name="idSessRm" type="number" value="<%= sess.getIdSession()%>">
	      		<SELECT size="1" name="idFormationRm">
		      		<%if (sess.getFormation()==null){%>
		      		<br> Aucune formation attitrée
		      		<%}else{%>
	      			<% com.lip6.entities.Formation form2=sess.getFormation();%>
					<OPTION value="<%= form2.toString().split("  |  ")[0]%>"><%= form2.getIdFormation()%>  |  <%= form2.getNomFormation() %>
					<% }%>
				</SELECT>	 
           		<br><button input type="submit" name="choix" value="rmFormation">Supprimer la formation
           	</td>
         </tr> 
 <!-- Gestion des formateurs -->      
         <tr>
           	<th id="afftd">Un formateur</th>
           	<td id="afftd">
           		<input type="HIDDEN" name="idSession" type="number" value="<%= sess.getIdSession()%>">    	
           		<SELECT size="1" name="idFormateur">
           			<% for (Object form:formateursdisponibles){%>
           				<OPTION VALUE="<%= form.toString().split("  |  ")[0]%>"><%= form %>	
					<% } %> 
				</SELECT> 
           		<br><button input type="submit" name="choix" value="assoFormateur">Ajouter le formateur
           	</td>
	        <td id="afftd">
	           	<input type="HIDDEN" name="idSessRm" type="number" value="<%= sess.getIdSession()%>">
	      		<SELECT size="1" name="idFormateurRm">
		      		<%if (sess.getFormateur()==null){%>
		      		<br> Aucune formateur attitré
		      		<%}else{%>
		     			<% com.lip6.entities.Formateur form2=sess.getFormateur();%>
					<OPTION value="<%= form2.toString().split("  |  ")[0]%>"><%= form2.getId() %>  |  <%=form2.getNom() %>
					<% }%>
				</SELECT>	           	
	           	<br><button input type="submit" name="choix" value="rmFormateur">Supprimer le formateur
	        </td>
     	</tr>   
<!-- Gestion des Stagiaires -->  
         <tr>
           	<th id = "afftd">Un stagiaire</th> 	
           	<td id = "afftd">
           		<input type="HIDDEN" name="idSession" type="number" value="<%= sess.getIdSession()%>">   	
           		<SELECT size="1" name="idStagiaire">
           			<% for (Object st:stagiairesdisponibles){ %>
  						</br><OPTION VALUE="<%= st.toString().split("  |  ")[0]%>"><%= st%>
					<% } %> 
				</SELECT> 
          		<br><button input type="submit" name="choix" value="assoStagiaire">Ajouter le stagiaire
          	</td>
        	<td id = "afftd">
           		<input type="HIDDEN" name="idSessRm" type="number" value="<%= sess.getIdSession()%>">
      			<SELECT size="1" name="idStagiaireRm">
      				<% for (com.lip6.entities.Stagiaire st:sess.getStagiaires()){ %>
   					<OPTION value="<%= st.toString().split("  |  ")[0]%>"><%= st.getId() %>  |  <%=st.getNom() %>
					<% } %>
				</SELECT>	 
           		<br><button input type="submit" name="choix" value="rmStagiaire">Supprimer le stagiaire
           	</td>
         </tr> 
<!-- Gestion des Clients -->     
         <tr>
           	<th id="afftd">Un client</th>   	
            	<td id="afftd">
            		<input type="HIDDEN" name="idSession" type="number" value="<%= sess.getIdSession()%>"> 	
            		<SELECT size="1" name="idClient">
            			<% for (Object client:clientsdisponibles){%>
            				<OPTION VALUE="<%= client.toString().split("  |  ")[0]%>"><%= client %>	
						<% } %> 
					</SELECT> 
           		<br><button input type="submit" name="choix" value="assoClient">Ajouter la session
        </td>
        <td id="afftd">
           	<input type="HIDDEN" name="idSessRm" type="number" value="<%= sess.getIdSession()%>">
      		<SELECT size="1" name="idClientRm">      		
      			<% for (com.lip6.entities.Client cl:sess.getClient()){ %>
   					<OPTION value="<%= cl.toString().split("  |  ")[0]%>"><%= cl.getId() %>  |  <%=cl.getNom() %>
				<% } %>
				</SELECT>	
           	<br><button input type="submit" name="choix" value="rmClient">Supprimer la session
        </td>
      </tr>
            
	</table>

</form>
<%@include file="footer.jsp" %>
</body>
</html>