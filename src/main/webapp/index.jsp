<%@ include file="header.jsp" %>

	<h2>Welcome to The Library</h2>
	
	
	<a href="<%= request.getContextPath()%>/login_patron.jsp">
		<button>Patron Login</button>
	</a>
	
	
	<br><br><br>
	
	
	<a href="<%= request.getContextPath()%>/login_librarian.jsp" >
		<button>Librarian Login</button>
	</a>


<%@ include file="footer.jsp" %>