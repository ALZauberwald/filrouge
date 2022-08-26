<%@page import="com.lip6.entities.Prerequis"%>
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
<div class="retreci">
<form action="UpdateFormationServlet" method="POST">
	
	<table id="afftbl" class="table "><caption class="caption-top">Voici le contenu de la formation selectionnee<br></caption>
	<!-- affichage du contenu de la formation -->          
	  	<thead>
        <tr class="table-info">
        	<td id="afftd">Id Formation</td>
        	<td id="afftd">Nom Formation</td>
        	<td id="afftd">Detail de la formation</td>
        	<td id="afftd">Objectifs</td>
        	<td id="afftd">Prerequis</td>
        	<td id="afftd">Sessions</td>
        	<td id="afftd">Themes</td>
        	<td id="afftd">Chapitres</td>
        </tr>
        </thead>
        <tbody>
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
        </tbody>
        <!-- affichage des modifications possibles (les champs)-->
        </table>
        <div class="table-responsive">
        <table class="table"><caption class="caption-top">Vous pouvez modifier un champ<br></caption>      
	        <thead>
		        <tr class="table-info">
		           	<td id="afftd">Formation</td>
		           	<td id="afftd">Champ a modifier</td> 
		       		<td id="afftd">Veuillez rentrer la valeur du champ a modifier</td>
		       		<td id="afftd">Modifier</td>    
		        </tr>
	        </thead>
	        <tbody>
		        <tr>
		        	<td id="afftd">n°<%= form.getIdFormation()%> <input type="HIDDEN" name="idFormation" type="number" value="<%= form.getIdFormation()%>"></td>
		        	<td id="afftd"><SELECT name="champAModif" size="1">
							<OPTION value="nom"> Nom de la formation (<%= form.getNomFormation()%>)
							<OPTION value="detail"> Detail de la formation (<%= form.getDetailFormation()%>)
						</SELECT>
					</td >
		        	<td id="afftd"> <input name="modif" type="text" /></td>
		        	<td id="afftd"><input type="submit" name="submit" value="modifier"></td>
		        </tr>
	        </tbody>
	   	</table>
	   	</div>
</form>
<!-- affichage des modifications d'associations possibles -->
<form action="UpdateFormation2Servlet" method="POST">
	<table id="afftbl" class="table  table-hover"> <caption class="caption-top">Vous pouvez modifier une association<br></caption>
		<tr class="table-info">
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
           			<br><div id="containerimg"><button input type="submit" name="choix" value="asso"><img src="images/plus.jpg" id="dimensionimg"></div>
        	</td>
        	<td id="afftd">
           	<input type="HIDDEN" name="idFormationRm" type="number" value="<%= form.getIdFormation()%>">
            	<SELECT size="1" name ="idObjectifRm">
            		<% for (com.lip6.entities.Objectif objectif:form.getObjectifsFormation()){%>
						<OPTION value="<%= objectif.toString().split("  |  ")[0]%>"> <%= objectif.getIdObjectif()%>  |  <%= objectif.getNomObjectif()%>
					<% } %> 
				</SELECT> 
				<br><div id="containerimg"><button input type="submit" name="choix" value="rm"><img src="images/logocorbeille.png" id="dimensionimg"></div>
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
        		<br><div id="containerimg"><button input type="submit" name="choix" value="assoPrerequis"><img src="images/plus.jpg" id="dimensionimg"></div>
        	</td>
        	<td id="afftd">
           		<input type="HIDDEN" name="idFormationRm" type="number" value="<%= form.getIdFormation()%>">
            	<SELECT size="1" name="idPrerequisRm">
            		<% for (com.lip6.entities.Prerequis prerequis:form.getPrerequisFormation()){%>
						<OPTION value="<%= prerequis.toString().split("  |  ")[0]%>"> <%= prerequis.getIdPrerequis()%>  |  <%= prerequis.getNomPrerequis()%>
					<% } %> 
				</SELECT> 
           		<br><div id="containerimg"><button input type="submit" name="choix" value="rmPrerequis"><img src="images/logocorbeille.png" id="dimensionimg"></div>
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
           		<br><div id="containerimg"><button input type="submit" name="choix" value="assoChapitre"><img src="images/plus.jpg" id="dimensionimg"></div>
           	</td>
        	<td id="afftd">
           		<input type="HIDDEN" name="idFormationRm" type="number" value="<%= form.getIdFormation()%>"> 	
            	<SELECT size="1" name="idChapitreRm">
            		<% for (com.lip6.entities.Chapitre chapitre:form.getChapitres()){%>
						<OPTION value="<%= chapitre.toString().split("  |  ")[0]%>"> <%= chapitre.getIdChapitre()%>  |  <%= chapitre.getNomChapitre()%>
					<% } %> 
				</SELECT> 
           		<br><div id="containerimg"><button input type="submit" name="choix" value="rmChapitre"><img src="images/logocorbeille.png" id="dimensionimg"></div>
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
           		<br><div id="containerimg"><button input type="submit" name="choix" value="assoTheme"><img src="images/plus.jpg" id="dimensionimg"></div>
           	</td>
       
           	<td id="afftd">
           		<input type="HIDDEN" name="idFormationRm" type="number" value="<%= form.getIdFormation()%>">
            	<SELECT size="1" name="idThemeRm">
            		<% for (com.lip6.entities.Theme theme:form.getTheme()){%>
						<OPTION value="<%= theme.toString().split("  |  ")[0]%>"> <%= theme.getIdTheme()%>  |  <%= theme.getNomTheme()%>
					<% } %> 
				</SELECT>            	
           		<br><div id="containerimg"><button input type="submit" name="choix" value="rmTheme"><img src="images/logocorbeille.png" id="dimensionimg"></div>
           	</td>
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
           			<br><div id="containerimg"><button input type="submit" name="choix" value="assoSession"><img src="images/plus.jpg" id="dimensionimg"></div>
           		</td>
       		<td id="afftd">
           		<input type="HIDDEN" name="idFormationRm" type="number" value="<%= form.getIdFormation()%>">
            	<SELECT size="1" name="idSessionRm">
            		<% for (com.lip6.entities.Session sess:form.getSessions()){ %>
						<OPTION value="<%= sess.toString().split("  |  ")[0]%>"> <%= sess.getIdSession()%>  |  <%= sess.getNomSession() %>
					<% } %> 
				</SELECT>            	
           		<br><div id="containerimg"><button input type="submit" name="choix" value="rmSession"><img src="images/logocorbeille.png" id="dimensionimg"></div>
           	</td>
         </tr>    
            
	</table>

</form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>