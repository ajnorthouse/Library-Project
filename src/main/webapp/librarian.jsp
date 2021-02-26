<%@page import="com.cognixia.jump.library.model.Patron"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header_librarian.jsp" %>


<% List<Patron> patrons = (List<Patron>) session.getAttribute("patrons");%>


	<h2>Welcome <%=session.getAttribute("username")%></h2>
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
			
			<td><form method="POST" action='LibrarianApprovesPatron'>
							<button name="freeze" value="<%=patron.getPatron_id()%>">Freeze Patron</button>
							</form></td>
			
		</tr>
		<%}
			}
			}%>
	</table><br>
	
	<h3>Frozen Patrons</h3>
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
							
							<td><form method="POST" action='LibrarianApprovesPatron'>
							<button name="freeze" value="<%=patron.getPatron_id()%>">Unfreeze Patron</button>
							</form>
							</td>
							
							
						</tr>
					<%}
				 }
	
			}%>
	</table>

<%@ include file="footer.jsp" %>
</html>