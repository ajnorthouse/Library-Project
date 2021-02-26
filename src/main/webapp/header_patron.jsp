<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Patron</title>
  </head>
  <body>
    <nav>
		<a href="BookServlet">View all Books</a>
		<a href="<%= request.getContextPath()%>/PatronUpdate">Update Info</a>
		<a href="<%= request.getContextPath()%>/LogOut">Log Out</a>
	</nav>
