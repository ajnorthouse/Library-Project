<%@ include file="header/index.jsp" %>

	<div class="login">	
		<h2>Patron Login:</h2>
		<form method="POST" action="PatronLogin">
			<label for="username">Username: </label><br>
			<input type="text" name="username" id="username">
			<br><br>
			
			<label for="password">Password: </label><br>
			<input type="password" name="password" id="password">
			<br><br>
			
			<%String error = (String)request.getAttribute("error");
				if (error != null) { %>
					<p style="color:red"> <%= error %></p>
				<% }
			%>
			
			<input type="submit">
			
			
		</form>
	</div>

<%@ include file="footer/index.jsp" %>