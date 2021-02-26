<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
</head>
<body>
  <h1>Update Profile</h1>
  <h2>Welcome <%=request.getAttribute("first_name" + "last_name")%></h2>
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
</body>
</html>