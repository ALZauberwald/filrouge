<%@page import="com.lip6.entities.Prerequis"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="form" scope="request" class="com.lip6.entities.Formation" ></jsp:useBean>
<jsp:useBean id="objectifsdisponibles" scope="request" class="java.util.HashSet" ></jsp:useBean>
<jsp:useBean id="prerequisdisponibles" scope="request" class="java.util.HashSet" ></jsp:useBean>
<jsp:useBean id="chapitresdisponibles" scope="request" class="java.util.HashSet" ></jsp:useBean>
<jsp:useBean id="themesdisponibles" scope="request" class="java.util.HashSet" ></jsp:useBean>
<jsp:useBean id="sessionsdisponibles" scope="request" class="java.util.HashSet" ></jsp:useBean>


<body>
 
<form action="UpdateFormationServlet" method="POST">
	<table>
	<!-- affichage du contenu de la formation -->          
	    	<h1>Modifier une formation dans la base de donnee.</h1> 
        <tr>
        	<h2>Voici le contenu de la formation selectionnee</h2>
           	<td><i>Id Formation</i> </br><%= form.getIdFormation() %> </td>
           	<td><i>nomFormation</i> </br><%= form.getNomFormation() %>  </td>
           	<td><i>Detail de la formation</i> </br><%= form.getDetailFormation() %>  </td>
             	
            <td><i>Objectifs</i>            
           		<% for (com.lip6.entities.Objectif objectif:form.getObjectifsFormation()){ %>
   				</br><%= objectif.getNomObjectif() %> 
				<% } %> 
            </td>
             <td><i>Prerequis</i> 
            	<% for (com.lip6.entities.Prerequis prerequis:form.getPrerequisFormation()){ %>
   				</br><%= prerequis.getNomPrerequis() %> 
				<% } %> 
			</td> 
             <td><i>Sessions</i> 
             	<% for (com.lip6.entities.Session ses:form.getSessions()){ %>
   				</br><%= ses.getNomSession() %> 
				<% } %>   
			</td> 
             <td><i>Theme</i> 
             	<% for (com.lip6.entities.Theme th:form.getTheme()){ %>
   				</br><%= th.getNomTheme() %> 
				<% } %>   
			</td>
            <td><i>Chapitres </i> 
            	<% for (com.lip6.entities.Chapitre cp:form.getChapitres()){ %>
   				</br><%= cp.getNomChapitre() %> 
				<% } %>   
			</td>     
        </tr>
        <!-- affichage des modifications possibles (les champs)-->
        <tr>
        	<h2>Pour modifier un champ</h2>
           	<td><i>Formation n°<%= form.getIdFormation()%></i> <input type="HIDDEN" name="idFormation" type="number" value="<%= form.getIdFormation()%>"></td>
           	<td><i>Veuillez choisir le champ à modifier</i>
           		<SELECT name="champAModif" size="1">
					<OPTION value="nom"> Nom de la formation (<%= form.getNomFormation()%>)
					<OPTION value="detail"> Detail de la formation (<%= form.getDetailFormation()%>)
				</SELECT> 
       		<td><i>Veuillez rentrer la valeur du champ à modifier</i> <input name="modif" type="text" /></td>
        </tr>
        <tr>
             <td><input type="submit" name="submit"></td>
        </tr>
   </table>
</form>
<!-- affichage des modifications d'associations possibles -->
<form action="UpdateFormation2Servlet" method="POST">
	<table>
		</br>
		<!-- Gestion des objectifs -->  
        <tr>
        	<h2>Pour modifier une association</h2>
           	<th>Vous voulez ajouter un objectif à la formation ?</th><input type="HIDDEN" name="idFormation" type="number" value="<%= form.getIdFormation()%>">    	
            	<td><i>Voici la liste des objectifs disponibles</i>	
            		<SELECT size="1">
            			<% for (Object objectif:objectifsdisponibles){%>
							<OPTION> <%= objectif%>	
						<% } %> 
					</SELECT> 
            	</td>
            	<td><i>Indiquez simplement le numéro de l'objectif que vous souhaitez ajouter</i><input name="idObjectif" type="number" ></td>
        <tr>
           	<td><button input type="submit" name="choix" value="asso">Ajouter l'objectif</td>
        </tr>
           	<th>Vous voulez supprimer un objectif de la formation ?</th><input type="HIDDEN" name="idFormationRm" type="number" value="<%= form.getIdFormation()%>">
           	<td><i>Voici la liste des objectifs qui sont pour l'instant liés à cette formation</i>
            	<SELECT size="1">
            		<% for (com.lip6.entities.Objectif objectif:form.getObjectifsFormation()){%>
						<OPTION value="objectif"> <%= objectif.getIdObjectif()%>  |  <%= objectif.getNomObjectif()%>
					<% } %> 
				</SELECT> 
           	</td>
           	<td><i>Indiquez simplement le numéro de l'objectif que vous souhaitez supprimer</i><input name="idObjectifRm" type="number" >
            	
         </tr>
         <tr>
           	<td><button input type="submit" name="choix" value="rm">Supprimer l'objectif</td>
         </tr>
            
          <!-- Gestion des prerequis -->  
          </br></br>
         <tr>
           	<th>Vous voulez ajouter un prerequis à la formation ?</th><input type="HIDDEN" name="idFormation" type="number" value="<%= form.getIdFormation()%>">    	
            	<td><i>Voici la liste des prerequis disponibles</i>	
            		<SELECT size="1">
            			<% for (Object prerequis:prerequisdisponibles){%>
							<OPTION> <%= prerequis %>	
						<% } %> 
					</SELECT> 
            	</td>
            	<td><i>Indiquez simplement le numéro du prerequis que vous souhaitez ajouter</i><input name="idPrerequis" type="number" ></td>
        <tr>
           	<td><button input type="submit" name="choix" value="assoPrerequis">Ajouter le prerequis</td>
        </tr>
           	<th>Vous voulez supprimer un prerequis de la formation ?</th><input type="HIDDEN" name="idFormationRm" type="number" value="<%= form.getIdFormation()%>">
           	<td><i>Voici la liste des prerequis qui sont pour l'instant liés à cette formation</i>
            	<SELECT size="1">
            		<% for (com.lip6.entities.Prerequis prerequis:form.getPrerequisFormation()){%>
						<OPTION value="prerequis"> <%= prerequis.getIdPrerequis()%>  |  <%= prerequis.getNomPrerequis()%>
					<% } %> 
				</SELECT> 
           	</td>
           	<td><i>Indiquez simplement le numéro du prerequis que vous souhaitez supprimer</i><input name="idPrerequisRm" type="number" >        	
         </tr>
         <tr>
           	<td><button input type="submit" name="choix" value="rmPrerequis">Supprimer le prerequis</td>
         </tr>
            
            <!-- Gestion des chapitres -->  
        <tr>
           	<th>Vous voulez ajouter un chapitre à la formation ?</th><input type="HIDDEN" name="idFormation" type="number" value="<%= form.getIdFormation()%>">    	
            	<td><i>Voici la liste des chapitres disponibles</i>	
            		<SELECT size="1">
            			<% for (Object chapitre:chapitresdisponibles){%>
							<OPTION> <%= chapitre %>	
						<% } %> 
					</SELECT> 
            	</td>
            	<td><i>Indiquez simplement le numéro du chapitre que vous souhaitez ajouter</i><input name="idChapitre" type="number" ></td>
        <tr>
           	<td><button input type="submit" name="choix" value="assoChapitre">Ajouter le chapitre</td>
        </tr>
           	<th>Vous voulez supprimer un chapitre de la formation ?</th><input type="HIDDEN" name="idFormationRm" type="number" value="<%= form.getIdFormation()%>">
           	<td><i>Voici la liste des chapitres qui sont pour l'instant liés à cette formation</i>
            	<SELECT size="1">
            		<% for (com.lip6.entities.Chapitre chapitre:form.getChapitres()){%>
						<OPTION value="chapitre"> <%= chapitre.getIdChapitre()%>  |  <%= chapitre.getNomChapitre()%>
					<% } %> 
				</SELECT> 
           	</td>
           	<td><i>Indiquez simplement le numéro du chapitre que vous souhaitez supprimer</i><input name="idChapitreRm" type="number" >
            	
         </tr>
         <tr>
           	<td><button input type="submit" name="choix" value="rmChapitre">Supprimer le chapitre</td>
         </tr>
         
         <!-- Gestion des themes -->  
         <tr>
           	<th>Vous voulez ajouter un theme à la formation ?</th><input type="HIDDEN" name="idFormation" type="number" value="<%= form.getIdFormation()%>">    	
            	<td><i>Voici la liste des themes disponibles</i>	
            		<SELECT size="1">
            			<% for (Object theme:themesdisponibles){%>
            				<OPTION><%= theme %>	
						<% } %> 
					</SELECT> 
            	</td>
            	<td><i>Indiquez simplement le numéro du theme que vous souhaitez ajouter</i><input name="idTheme" type="number" ></td>
        <tr>
           	<td><button input type="submit" name="choix" value="assoTheme">Ajouter le theme</td>
        </tr>
           	<th>Vous voulez supprimer un theme de la formation ?</th><input type="HIDDEN" name="idFormationRm" type="number" value="<%= form.getIdFormation()%>">
           	<td><i>Voici la liste des themes qui sont pour l'instant liés à cette formation</i>
            	<SELECT size="1">
            		<% for (com.lip6.entities.Theme theme:form.getTheme()){%>
						<OPTION value="Theme"> <%= theme.getIdTheme()%>  |  <%= theme.getNomTheme()%>
					<% } %> 
				</SELECT> 
           	</td>
           	<td><i>Indiquez simplement le numéro du theme que vous souhaitez supprimer</i><input name="idThemeRm" type="number" >
            	
         </tr>
         <tr>
           	<td><button input type="submit" name="choix" value="rmTheme">Supprimer le theme</td>
         </tr> 
            
         <!-- Gestion des sessions -->  
         <tr>
           	<th>Vous voulez ajouter une session à la formation ?</th><input type="HIDDEN" name="idFormation" type="number" value="<%= form.getIdFormation()%>">    	
            	<td><i>Voici la liste des sessions disponibles</i>	
            		<SELECT size="1">
            			<% for (Object sess:sessionsdisponibles){%>
            				<OPTION><%= sess %>	
						<% } %> 
					</SELECT> 
            	</td>
            	<td><i>Indiquez simplement le numéro de la session que vous souhaitez ajouter</i><input name="idSession" type="number" ></td>
        <tr>
           	<td><button input type="submit" name="choix" value="assoSession">Ajouter la session</td>
        </tr>
           	<th>Vous voulez supprimer une session de la formation ?</th><input type="HIDDEN" name="idFormationRm" type="number" value="<%= form.getIdFormation()%>">
           	<td><i>Voici la liste des sessions qui sont pour l'instant liés à cette formation</i>
            	<SELECT size="1">
            		<% for (com.lip6.entities.Session sess:form.getSessions()){ %>
						<OPTION value="Session"> <%= sess.getIdSession()%>  |  <%= sess.getNomSession() %>
					<% } %> 
				</SELECT> 
           	</td>
           	<td><i>Indiquez simplement le numéro de la session que vous souhaitez supprimer</i><input name="idSessionRm" type="number" >
            	
         </tr>
         <tr>
           	<td><button input type="submit" name="choix" value="rmSession">Supprimer la session</td>
         </tr>    
            
	</table>

</form>
<br>
</body>
</html>