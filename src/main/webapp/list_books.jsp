<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Catalog</title>
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
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>