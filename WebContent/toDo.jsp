<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList" import="fr.eni.ejb.bean.ToDo"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>EJB</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
		<script src="https://kit.fontawesome.com/5e4d9b3b67.js" crossorigin="anonymous"></script>
	</head>
	<body class="container-fluid" style="background-color:black;color:white;text-align:center">
		<a href="./deconnexion" style="float:left"><img src="logo-eni.png"></a>
		<h1 style="float:center">TO DO APP
			<span style="float:right">
				<div class="btn-group dropleft">
				  <button type="button" class="btn btn-primary">Compte</button>
				  <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    <span class="sr-only">Toggle Dropdown</span>
				  </button>
				  <div class="dropdown-menu" style="background-color:black;border-color:white">
				    <a class="dropdown-item text-primary" href="./modifNom.jsp">Modifier nom</a>
				    <a class="dropdown-item text-primary" href="./modifMdp.jsp">Modifier mot de passe</a>
				    <div class="dropdown-divider"></div>
				    <a class="dropdown-item text-danger" href="./suppCompte.jsp">Supprimer le compte</a>
				  </div>
				</div>
			</span>
		</h1><br/>
		<h3 style="float:left">&nbsp;Liste des TODO de <span style="color:#0083FF"><%= session.getAttribute("nom") %></span></h3><br/>
		<table class="table table-dark">
			<thead style="background-color:#0083FF">
			   <tr>
			      <th scope="col">TO DO</th>
			      <th scope="col">Action</th>
			   </tr>
			 </thead>
			 <tbody>
			 	<% ArrayList<ToDo> liste = (ArrayList<ToDo>) session.getAttribute("toDo");
			 	for (ToDo td : liste) {
			 	%>
					 <tr>
					      <td><%= td.getLibelle() %></td>
					      <td>
						      <form method="post" action="./maj">
						      	<input type="hidden" value="<%= td.getId() %>" name="up">
						      	<button type="submit" class="btn btn-warning" aria-label="Left Align" style="margin-bottom:2px">
 									<span class="fas fa-edit" aria-hidden="true">&nbsp;Modifier</span>
 								</button>
						      </form>
						      <form method="post" action="./effacer">
						      	<input type="hidden" value="<%= td.getId() %>" name="er">
						      	<button type="submit" class="btn btn-danger" aria-label="Left Align">
 									<span class="fas fa-trash-alt" aria-hidden="true">&nbsp;Supprimer</span>
 								</button>
						      </form>
					      </td>
					  </tr>
				<% } %>
		 	</tbody>
		</table>
		<br/>
		<form method="post" action="./newToDo.jsp">
			<button type="submit" class="btn btn-primary" aria-label="Left Align" style="float:center">
 				<span class="fas fa-plus" aria-hidden="true"></span>
 			</button>
		</form>
	</body>
</html>