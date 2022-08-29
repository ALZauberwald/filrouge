<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styles.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
	<div class="table-responsive ">
		<table class="table "id ="afftbl"><caption class="caption-top aligncenter" >Voici le contenu de la session selectionnee<br></caption>
			<tr class="table-info " >
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
	        	<td id ="afftd">Stagiaires</td>   
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
		            <td id="affcell" class="cell"> 
			            <%if (sess.getSalle()==null){%>
		      				NA</br>
		      			<%}else{%>      			
		             	<% com.lip6.entities.Salle sa=sess.getSalle();%>
		   				Adresse :<%= sa.getAdresse() %>
		   				</br>Nom Salle : <%= sa.getNomSalle() %> 
						<% }%>
					</td>
					<td id= "afftd" >
	             		<% for (com.lip6.entities.Stagiaire st:sess.getStagiaires()){ %>
		   				<li class="cell"><%= st.getNom() %> <%=st.getPrenom() %></li>
						<% } %> 
						</ul>  
					</td>
					<td id= "afftd">
		             	<% for (com.lip6.entities.Client cl:sess.getClient()){ %>
		   				<li class="cell"><%= cl.getNom() %> <%=cl.getPrenom() %></li>
						<% } %>   
					</td>	            
	            </tr>
	     	</table>
	     </div>
	     <div class="retreci">
	     	<form action="UpdateSessionServlet" method="POST">
		     	<table class="table"id ="afftbl"><caption class="caption-top">Modifier un champ</caption>
		            <thead>
		        		<tr class="table-info">	
		            	<td id="afftd">Session</td>
		            	<td id="afftd">Veuillez rentrer le champ à modifier</td>
		            	<td id="afftd">Veuillez rentrer la valeur du champ à modifier</td>
		            	<td id="afftd">Modifier</td>
		            </tr>
		            <tr>
		            	<td id="afftd">n°<%= sess.getIdSession()%><input name="idSession" type="hidden" type="number" value="<%= sess.getIdSession()%>"/></td>
		            	<td id="afftd">
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
						</td >
			            <td id="afftd"><input name="modif" type="text" /></td>
			            <td id="afftd"><input type="submit" name="submit" value="modifier"></td>
		            </tr>
			</table>
		</form>
	</div>
	<!-- affichage des modifications d'associations possibles -->
	<div class="retreci">
	<form action="UpdateSession2Servlet" method="POST">
		<table class="table"id="afftbl"> <caption class="caption-top">Vous pouvez modifier une association<br></caption>
			<tr class="table-info">
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
	           		<br><div id="containerimg"><button input type="submit" name="choix" value="assoSalle"><img src="images/plus.jpg" id="dimensionimg"></div>
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
	           		<br><div id="containerimg"><button input type="submit" name="choix" value="rmSalle"><img src="images/logocorbeille.png" id="dimensionimg"></div>
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
	           		<br><div id="containerimg"><button input type="submit" name="choix" value="assoFormation"><img src="images/plus.jpg" id="dimensionimg"></div>
	           </td>
	        	<td id="afftd">
	           		<input type="HIDDEN" name="idSessRm" type="number" value="<%= sess.getIdSession()%>">
		      		<SELECT size="1" name="idFormationRm">
			      		<%if (sess.getFormation()==null){%>
			      		<br> Aucune formation attitrée
			      		<%}else{%>
		      			<% com.lip6.entities.Formation form2=sess.getFormation();%>
						<OPTION value="<%= form2.toString().split("  |  ")[0]%>"><%= form2.getIdFormation()%>  |  <%= form2.getNomFormation() %>
						<% }%>
					</SELECT>	 
	           		<br><div id="containerimg"><button input type="submit" name="choix" value="rmFormation"><img src="images/logocorbeille.png" id="dimensionimg"></div>
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
	           		<br><div id="containerimg"><button input type="submit" name="choix" value="assoFormateur"><img src="images/plus.jpg" id="dimensionimg"></div>
	           	</td>
		        <td id="afftd">
		           	<input type="HIDDEN" name="idSessRm" type="number" value="<%= sess.getIdSession()%>">
		      		<SELECT size="1" name="idFormateurRm">
			      		<%if (sess.getFormateur()==null){%>
			      		<br> Aucun formateur attitré
			      		<%}else{%>
			     			<% com.lip6.entities.Formateur form2=sess.getFormateur();%>
						<OPTION value="<%= form2.toString().split("  |  ")[0]%>"><%= form2.getId() %>  |  <%=form2.getNom() %>
						<% }%>
					</SELECT>	           	
		           	<br><div id="containerimg"><button input type="submit" name="choix" value="rmFormateur"><img src="images/logocorbeille.png" id="dimensionimg"></div>
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
	          		<br><div id="containerimg"><button input type="submit" name="choix" value="assoStagiaire"><img src="images/plus.jpg" id="dimensionimg"></div>
	          	</td>
	        	<td id = "afftd">
	           		<input type="HIDDEN" name="idSessRm" type="number" value="<%= sess.getIdSession()%>">
	      			<SELECT size="1" name="idStagiaireRm">
	      				<% for (com.lip6.entities.Stagiaire st:sess.getStagiaires()){ %>
	   					<OPTION value="<%= st.toString().split("  |  ")[0]%>"><%= st.getId() %>  |  <%=st.getNom() %>
						<% } %>
					</SELECT>	 
	           		<br><div id="containerimg"><button input type="submit" name="choix" value="rmStagiaire"><img src="images/logocorbeille.png" id="dimensionimg"></div>
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
	           		<br><div id="containerimg"><button input type="submit" name="choix" value="assoClient"><img src="images/plus.jpg" id="dimensionimg"></div>
	        </td>
	        <td id="afftd">
	           	<input type="HIDDEN" name="idSessRm" type="number" value="<%= sess.getIdSession()%>">
	      		<SELECT size="1" name="idClientRm">      		
	      			<% for (com.lip6.entities.Client cl:sess.getClient()){ %>
	   					<OPTION value="<%= cl.toString().split("  |  ")[0]%>"><%= cl.getId() %>  |  <%=cl.getNom() %>
					<% } %>
					</SELECT>	
	           	<br><div id="containerimg"><button input type="submit" name="choix" value="rmClient"><img src="images/logocorbeille.png" id="dimensionimg"></div>
	        </td>
	      </tr>
	            
		</table>
	
	</form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>