<%@ include file="header.jsp" %>

	<div class="login">	
		<h2>Librarian Login:</h2>
		<form method="POST" action="LibrarianLogin">
			<label for="username">Username: </label><br>
			<input type="text" name="username" id="username">
			<br><br>
			
			<label for="password">Password: </label><br>
			<input type="password" name="password" id="password">
			<br><br>
			
			<input type="submit">
		</form>
	</div>

<%@ include file="footer.jsp" %>