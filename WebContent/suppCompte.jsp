<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="fr.eni.ejb.bean.ToDo"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>EJB</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	</head>
	<body class="container-fluid" style="background-color:black;color:white;text-align:center">
		<img src="logo-eni.png" style="float:left">
		<h1>TO DO APP</h1><br/>
		<h3>Suppression du compte <span style="color:#0083FF"><%= session.getAttribute("nom") %></span></h3><br/>
		<div>
			La suppression du compte effacera totalement la présence de celui-ci dans nos bases de données. (rendant l'opération irréversible).<br>
			De plus, tous les TODO associés seront eux-aussi supprimés.
			Etes-vous sûr de vouloir supprimer votre compte ?
		</div>
		<form method="post" action="./delCompte">
			<input type="hidden" name="idCompte" value="<%= session.getAttribute("id") %>">
			<div><input class="btn btn-danger" name="del" type="submit" value="Supprimer le compte" style="margin-bottom:2px"></div>
		</form>
		<form method="post" action="./delCompte">
			<input class="btn btn-secondary" type="submit" value="Annuler">
		</form>
	</body>
</html>