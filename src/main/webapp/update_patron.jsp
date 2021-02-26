<%@ include file="header_patron.jsp" %>

  <h1>Update Profile</h1>
  <h2>Welcome <%=request.getAttribute("first_name")%> <%=request.getAttribute("last_name")%></h2>
<form action="" method="post">
	<table style="width: 50%">
	  <tr>
	    <td><input type="hidden" id="patron_id" name="patron_id" value="<%=request.getAttribute("patron_id")%>"></td>
	  </tr>
	  <tr>
		<td>First Name</td>
		<td><input type="text" name="first_name" value="<%=request.getAttribute("first_name")%>"/></td>
	  </tr>
	  <tr>
		<td>Last Name</td>
		<td><input type="text" name="last_name" value="<%=request.getAttribute("last_name")%>"/></td>
	  </tr>
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