<%@ include file="header.jsp" %>

<h1>Patron Register Form</h1>
<form action="PatronSignup" method="post">
	<table style="width: 50%">
	  <tr>
		<td>First Name</td>
		<td><input type="text" name="first_name" /></td>
	  </tr>
	  <tr>
		<td>Last Name</td>
		<td><input type="text" name="last_name" /></td>
	  </tr>
		<tr>
		<td>UserName</td>
		<td><input type="text" name="username" /></td>
	  </tr>
	  <tr>
		<td>Password</td>
		<td><input type="password" name="password" /></td>
	  </tr>
	</table>
		<input type="submit" value="Submit" />
</form>

<%@ include file="footer.jsp" %>