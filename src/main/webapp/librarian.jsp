<%@page import="com.cognixia.jump.library.model.Patron"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>


<% List<Patron> patrons = (List<Patron>) request.getAttribute("patron");%>

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
		<tr>
			<td><%=patron.getPatron_id() %></td>
			<td><%=patron.getUsername() %></td>
			<td><%=patron.getFirst_name() %></td>
			<td><%=patron.getLast_name() %></td>
			<td><%=patron.isAccount_frozen() %></td>
		</tr>
		<%}
			}%>
	</table>
	
	<a href='update_librarian.jsp'><button>Update account</button></a>
	<a href='LibrarianApprovePatrons'><button>Freeze/Unfreeze Selected Patrons</button></a>
</body>

<%@ include file="footer.jsp" %>
</html>