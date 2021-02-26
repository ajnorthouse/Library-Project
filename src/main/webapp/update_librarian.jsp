<%@ include file="header_librarian.jsp" %>

<body>
	<form method="POST">
		<table style="width: 50%">
	  
		<tr>
		<td>UserName</td>
		<td><input type="text" name="username" placeholder="<%=request.getAttribute("username")%>"/></td>
	  </tr>
	  <tr>
		<td>Password</td>
		<td><input type="password" name="password" placeholder="<%=request.getAttribute("password")%>"/></td>
	  </tr>
	</table>
		<input type="submit" value="Submit" />
	</form>

<%@ include file="footer.jsp" %>