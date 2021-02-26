<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patron Dash board</title>
</head>
<body>
	<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Book Catalog</h2></caption>
            <tr>
                <th>ISBN</th>
                <th>TITLE</th>
                <th>DESCRIPTION</th>
            </tr>
            <c:forEach var="book" items="${listBooks.rows}">
                <tr>
                    <td><c:out value="${book.isbn}" /></td>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.description}" /></td>
                    <td><button type="radio" placeholder="CHECKOUT"></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>CURRENT BOOKS</h2></caption>
            <tr>
                <th>ISBN</th>
                <th>TITLE</th>
                <th>DESCRIPTION</th>
            </tr>
            <c:forEach var="book" items="${listBooks.rows}">
                <tr>
                    <td><c:out value="${book.isbn}" /></td>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.description}" /></td>
                    <td><button type="radio" placeholder="CHECKOUT"></td>
                </tr>
            </c:forEach>
        </table>
    </div>
	<a href="<%= request.getContextPath()%>/list_books.jsp">View all Books</a>
</body>
</html>