<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Librarian</title>
  </head>
  <body>
    <nav>
		<a href="<%= request.getContextPath()%>/LibrarianApprovesPatron">Manage Patrons</a>
		<a href="<%= request.getContextPath()%>/LibrarianUpdate">Update Info</a>
		<a href="<%= request.getContextPath()%>/LogOut">Log Out</a>
	</nav>
