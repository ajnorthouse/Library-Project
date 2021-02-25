<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Navigation</title>
  </head>
  <body>
    <nav> 
		<a href="<%= request.getContextPath()%>">Home</a> 
		<a href="<%= request.getContextPath()%>/list_books.jsp">View all Books</a>
		<a href="<%= request.getContextPath()%>/return.jsp">Return a Book</a> 
		<a href="<%= request.getContextPath()%>/history.jsp">Borrowing History</a> 
		<a href="<%= request.getContextPath()%>/login.jsp">Login</a> 
		<a href="<%= request.getContextPath()%>/register.jsp">Register</a> 
		<form method="GET" action=SERVLET>
			<input type="number" min="1" placeholder="isbn" name="id">
			<input type="submit" value="Search Book"/>
		</form>
	</nav>
