<%@page import="com.cognixia.jump.library.model.Patron"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header/librarian.jsp" %>


<% List<Patron> patrons = (List<Patron>) request.getAttribute("patrons");%>

<body>
	<h2>Welcome <%=request.getAttribute("username") %></h2>
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
			
			<td><a href='LibrarianApprovesPatron'><button name="freeze" value="true" placeholder="freeze">Freeze Patron</button></a></td>
			
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
							
							<td><a href='LibrarianApprovesPatron'><button name="freeze" value="false" placeholder="unfreeze">Unfreeze Patron</button></a></td>
							
						</tr>
					<%}
				 }
	
			}%>
	</table>
	
	<a href='update_librarian.jsp'><button>Update account</button></a>
	
</body>

<%@ include file="footer/index.jsp" %>
</html>