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
<jsp:useBean id="sessionsdisponibles" scope="request" class="java.util.HashSet" ></jsp:useBean>


<body>
 
<form action="UpdateFormationServlet" method="POST">
	<table>
		<tr>          
	    	<td><i>Modifier une formation dans la base de donnée.</i> 
        </tr>
        <tr>
           	<td><i>Id Formation</i> <%= form.getIdFormation() %> </td>
           	<td><i>nomFormation</i> <%= form.getNomFormation() %>  </td>
           	<td><i>Detail de la formation</i> <%= form.getDetailFormation() %>  </td>
             	
            <td><i>Objectifs</i>            
           		<% for (com.lip6.entities.Objectif objectif:form.getObjectifsFormation()){ %>
   				<%= objectif.getNomObjectif() %> </br>
				<% } %> 
            </td>
             <td><i>Prerequis</i> 
            	<% for (com.lip6.entities.Prerequis prerequis:form.getPrerequisFormation()){ %>
   				<%= prerequis.getNomPrerequis() %> </br>
				<% } %> 
			</td> 
             <td><i>Sessions</i> 
             	<% for (com.lip6.entities.Session ses:form.getSessions()){ %>
   				<%= ses.getNomSession() %> </br>
				<% } %>   
			</td> 
             <td><i>Theme</i> 
             	<% for (com.lip6.entities.Theme th:form.getTheme()){ %>
   				<%= th.getNomTheme() %> </br>
				<% } %>   
			</td>
            <td><i>Chapitres </i> 
            	<% for (com.lip6.entities.Chapitre cp:form.getChapitres()){ %>
   				<%= cp.getNomChapitre() %> </br>
				<% } %>   
			</td>     
        </tr>
        <tr>
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

<form action="UpdateFormation2Servlet" method="POST">
	<table>
		</br>
		<!-- Gestion des objectifs -->  
        <tr>
           	<th>Vous voulez ajouter un objectif à la formation ?</th><input type="HIDDEN" name="idFormation" type="number" value="<%= form.getIdFormation()%>">    	
            	<td><i>Voici la liste des objectifs disponibles</i>	
            		<SELECT size="1">
            			<% for (Object objectif:objectifsdisponibles){%>
							<OPTION> <%= objectif.toString().split("idObjectif=")[1].split(",")[0]+"  |  "+objectif.toString().split("nomObjectif=")[1].split("]")[0]%>	
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
						<OPTION value="objectif"> <%= objectif.getNomObjectif()%>
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
							<OPTION> <%= prerequis.toString().split("idPrerequis=")[1].split(",")[0]+"  |  "+prerequis.toString().split("nomPrerequis=")[1].split("]")[0]%>	
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
						<OPTION value="prerequis"> <%= prerequis.getNomPrerequis()%>
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
							<OPTION> <%= chapitre.toString().split("idChapitre=")[1].split(",")[0]+"  |  "+chapitre.toString().split("nomChapitre=")[1].split(", ")[0]%>	
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
						<OPTION value="chapitre"> <%= chapitre.getNomChapitre()%>
					<% } %> 
				</SELECT> 
           	</td>
           	<td><i>Indiquez simplement le numéro du chapitre que vous souhaitez supprimer</i><input name="idChapitreRm" type="number" >
            	
         </tr>
         <tr>
           	<td><button input type="submit" name="choix" value="rmChapitre">Supprimer le chapitre</td>
         </tr>
            
	</table>

</form>
<br>
</body>
</html>