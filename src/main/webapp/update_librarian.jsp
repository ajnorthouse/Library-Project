<%@ include file="header_librarian.jsp" %>


  <h1>Update Profile</h1>
  <h2>Welcome <%=request.getAttribute("username")%>!</h2>
	<form method="POST">
		<table style="width: 50%">
	  
		<tr>
		<td>UserName</td>
		<td><input type="text" name="username" value="<%=request.getAttribute("username")%>"/></td>
	  </tr>
	  <tr>
		<td>Password</td>
		<td><input type="password" name="password" value="<%=request.getAttribute("password")%>"/></td>
	  </tr>
	</table>
		<input type="submit" value="Submit" />
	</form>

<%@ include file="footer.jsp" %>