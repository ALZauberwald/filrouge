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
 <%@ include file="header.jsp" %>
	<br>
	<br>
	<br>
	<br>
<form action="UpdateFormationServlet" method="POST">
	
	<table id="afftbl"><caption>Voici le contenu de la formation selectionnee<br></caption>
	<!-- affichage du contenu de la formation -->          
	    	
        <tr>
        	<td>Id Formation</td>
        	<td>Nom Formation</td>
        	<td>Detail de la formation</td>
        	<td>Objectifs</td>
        	<td>Prerequis</td>
        	<td>Sessions</td>
        	<td>Themes</td>
        	<td>Chapitres</td>
        </tr>
        <tr id="afftr">
        	
           	<td id="afftd"><%= form.getIdFormation() %> </td>
           	<td id="afftd"><%= form.getNomFormation() %>  </td>
           	<td id="afftd"><%= form.getDetailFormation() %>  </td>
             	
            <td id="afftd">            
           		<% for (com.lip6.entities.Objectif objectif:form.getObjectifsFormation()){ %>
   				<%= objectif.getNomObjectif() %> 
				<% } %> 
            </td>
             <td id="afftd"> 
            	<% for (com.lip6.entities.Prerequis prerequis:form.getPrerequisFormation()){ %>
   				<%= prerequis.getNomPrerequis() %> 
				<% } %> 
			</td> 
             <td id="afftd"> 
             	<% for (com.lip6.entities.Session ses:form.getSessions()){ %>
   				<%= ses.getNomSession() %> 
				<% } %>   
			</td> 
             <td id="afftd">
             	<% for (com.lip6.entities.Theme th:form.getTheme()){ %>
   				<%= th.getNomTheme() %> 
				<% } %>   
			</td>
            <td id="afftd"> 
            	<% for (com.lip6.entities.Chapitre cp:form.getChapitres()){ %>
   				</br><%= cp.getNomChapitre() %> 
				<% } %>   
			</td>     
        </tr>
        <!-- affichage des modifications possibles (les champs)-->
        <tr>        
        	
		</tr>       
        <tr>
       	 <th>Vous pouvez modifier un champ</th>
           	<td><i>Formation n�<%= form.getIdFormation()%></i> <input type="HIDDEN" name="idFormation" type="number" value="<%= form.getIdFormation()%>"></td>
           	<td><i>Veuillez choisir le champ a modifier</i>
           		<SELECT name="champAModif" size="1">
					<OPTION value="nom"> Nom de la formation (<%= form.getNomFormation()%>)
					<OPTION value="detail"> Detail de la formation (<%= form.getDetailFormation()%>)
				</SELECT> 
       		<td><i>Veuillez rentrer la valeur du champ a modifier</i> <input name="modif" type="text" /></td>
             <td><input type="submit" name="submit"></td>
        </tr>
   </table>
</form>
<!-- affichage des modifications d'associations possibles -->
<form action="UpdateFormation2Servlet" method="POST">
	<table id="afftbl"> <caption>Vous pouvez modifier une association<br></caption>
		<tr>
			<td id="afftd">avec</td>
			<td id="afftd">Ajouter</td>
			<td id="afftd">Supprimer</td>
		</tr>
        <!-- Gestion des objectifs --> 
        <tr>
           	<th id="afftd">Un objectif</th>
           	<td id="afftd">	
            		<SELECT size="1" name = "idObjectif">
            			<% for (Object objectif:objectifsdisponibles){%>
							<OPTION value ="<%= objectif.toString().split("  |  ")[0]%>"> <%= objectif%>	
						<% } %> 
					</SELECT> 
            		<input type="HIDDEN" name="idFormation" type="number" value="<%= form.getIdFormation()%>"> 
           			<br><button input type="submit" name="choix" value="asso">Ajouter l'objectif
        	</td>
        	<td id="afftd">
           	<input type="HIDDEN" name="idFormationRm" type="number" value="<%= form.getIdFormation()%>">
            	<SELECT size="1" name ="idObjectifRm">
            		<% for (com.lip6.entities.Objectif objectif:form.getObjectifsFormation()){%>
						<OPTION value="<%= objectif.toString().split("  |  ")[0]%>"> <%= objectif.getIdObjectif()%>  |  <%= objectif.getNomObjectif()%>
					<% } %> 
				</SELECT> 
				<br><button input type="submit" name="choix" value="rm">Supprimer l'objectif
           	</td>
            	
         </tr>
               <!-- Gestion des prerequis -->  
          </br></br>
         <tr>
           	<th id="afftd">Un prerequis</th>
           	<td id="afftd">
           		<input type="HIDDEN" name="idFormation" type="number" value="<%= form.getIdFormation()%>">    	
           		<SELECT size="1" name="idPrerequis">
           			<% for (Object prerequis:prerequisdisponibles){%>
						<OPTION value="<%= prerequis.toString().split("  |  ")[0]%>"> <%= prerequis %>	
					<% } %> 
				</SELECT> 
        		<br><button input type="submit" name="choix" value="assoPrerequis">Ajouter le prerequis
        	</td>
        	<td id="afftd">
           		<input type="HIDDEN" name="idFormationRm" type="number" value="<%= form.getIdFormation()%>">
            	<SELECT size="1" name="idPrerequisRm">
            		<% for (com.lip6.entities.Prerequis prerequis:form.getPrerequisFormation()){%>
						<OPTION value="<%= prerequis.toString().split("  |  ")[0]%>"> <%= prerequis.getIdPrerequis()%>  |  <%= prerequis.getNomPrerequis()%>
					<% } %> 
				</SELECT> 
           		<br><button input type="submit" name="choix" value="rmPrerequis">Supprimer le prerequis
           	</td>
         </tr>
            
            <!-- Gestion des chapitres -->  
        <tr> 	
           	<th id="afftd">Un chapitre</th>       	  	
            <td id="afftd">
            	<input type="HIDDEN" name="idFormation" type="number" value="<%= form.getIdFormation()%>">  
           		<SELECT size="1" name="idChapitre">
           			<% for (Object chapitre:chapitresdisponibles){%>
						<OPTION value="<%= chapitre.toString().split("  |  ")[0]%>"> <%= chapitre %>	
					<% } %> 
				</SELECT>     
           		<br><button input type="submit" name="choix" value="assoChapitre">Ajouter le chapitre</td>
        	<td id="afftd">
           		<input type="HIDDEN" name="idFormationRm" type="number" value="<%= form.getIdFormation()%>"> 	
            	<SELECT size="1" name="idChapitreRm">
            		<% for (com.lip6.entities.Chapitre chapitre:form.getChapitres()){%>
						<OPTION value="<%= chapitre.toString().split("  |  ")[0]%>"> <%= chapitre.getIdChapitre()%>  |  <%= chapitre.getNomChapitre()%>
					<% } %> 
				</SELECT> 
           		<br><button input type="submit" name="choix" value="rmChapitre">Supprimer le chapitre
           	</td>
         </tr>
         
         <!-- Gestion des themes -->  
         <tr>
           	<th id="afftd">Un theme</th>
           	<td id="afftd">
           		<input type="HIDDEN" name="idFormation" type="number" value="<%= form.getIdFormation()%>">    		
           		<SELECT size="1" name="idTheme">
           			<% for (Object theme:themesdisponibles){%>
           				<OPTION value="<%= theme.toString().split("  |  ")[0]%>"><%= theme %>	
					<% } %> 
				</SELECT> 
           		<br><button input type="submit" name="choix" value="assoTheme">Ajouter le theme
           	</td>
       
           	<td id="afftd">
           		<input type="HIDDEN" name="idFormationRm" type="number" value="<%= form.getIdFormation()%>">
            	<SELECT size="1" name="idThemeRm">
            		<% for (com.lip6.entities.Theme theme:form.getTheme()){%>
						<OPTION value="<%= theme.toString().split("  |  ")[0]%>"> <%= theme.getIdTheme()%>  |  <%= theme.getNomTheme()%>
					<% } %> 
				</SELECT>            	
           		<br><button input type="submit" name="choix" value="rmTheme">Supprimer le theme</td>
         </tr> 
            
         <!-- Gestion des sessions -->  
         <tr>
           	<th id="afftd">Une session</th>   	
            	<td id="afftd">
            		<input type="HIDDEN" name="idFormation" type="number" value="<%= form.getIdFormation()%>"> 
            		<SELECT size="1" name="idSession">
            			<% for (Object sess:sessionsdisponibles){%>
            				<OPTION value="<%= sess.toString().split("  |  ")[0]%>"><%= sess %>	
						<% } %> 
					</SELECT> 
           			<br><button input type="submit" name="choix" value="assoSession">Ajouter la session
           		</td>
       		<td id="afftd">
           		<input type="HIDDEN" name="idFormationRm" type="number" value="<%= form.getIdFormation()%>">
            	<SELECT size="1" name="idSessionRm">
            		<% for (com.lip6.entities.Session sess:form.getSessions()){ %>
						<OPTION value="<%= sess.toString().split("  |  ")[0]%>"> <%= sess.getIdSession()%>  |  <%= sess.getNomSession() %>
					<% } %> 
				</SELECT>            	
           		<br><button input type="submit" name="choix" value="rmSession">Supprimer la session
           	</td>
         </tr>    
            
	</table>

</form>
<%@include file="footer.jsp" %>
</body>
</html>