<%@page import="com.cognixia.jump.library.model.Patron"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header/librarian.jsp" %>


<% List<Patron> patrons = (List<Patron>) session.getAttribute("patrons");%>

<body>
	<h2>Welcome <%=session.getAttribute("username") %></h2>
	<h3>Patron List</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>UserName</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Frozen</th>
		</tr>
		<%if(patrons != null) {
			for(Patron patron:patrons) {%>
			<% if(patron.isAccount_frozen()==false) {%>
		<tr>
			<td><%=patron.getPatron_id() %></td>
			<td><%=patron.getUsername() %></td>
			<td><%=patron.getFirst_name() %></td>
			<td><%=patron.getLast_name() %></td>
			<td><%=patron.isAccount_frozen() %></td>
			
			<td><form method="POST" action='LibrarianApprovesPatron'>
							<input type="submit" name="freeze" value="<%=patron.getPatron_id()%>">Freeze Patron</form></td>
			
		</tr>
		<%}
			}
			}%>
	</table><br>
	
	<h3>Newly signed up Patron List</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>UserName</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Frozen</th>
		</tr>
		<%if(patrons != null) {
				for(Patron patron:patrons) {%>
					<% if(patron.isAccount_frozen()==true) {%>
						<tr>
							<td><%=patron.getPatron_id() %></td>
							<td><%=patron.getUsername() %></td>
							<td><%=patron.getFirst_name() %></td>
							<td><%=patron.getLast_name() %></td>
							<td><%=patron.isAccount_frozen() %></td>
							
							<td><form method="POST" action='LibrarianApprovesPatron'>
							<input type="submit" name="freeze" value="<%=patron.getPatron_id()%>">Unfreeze Patron</form></td>
							
							
						</tr>
					<%}
				 }
	
			}%>
	</table>
	
	<a href='LibrarianUpdate'><button>Update account</button></a>
	
</body>

<%@ include file="footer/index.jsp" %>
</html>