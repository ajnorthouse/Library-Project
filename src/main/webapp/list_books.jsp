<%@page import="java.util.ArrayList"%>
<%@page import="com.cognixia.jump.library.model.Book"%>
<%@page import="java.util.List"%>
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
        	<%List<Book> books = (List<Book>) request.getAttribute("books");%>
            <caption><h2>Book Catalog</h2></caption>
            <tr>
                <th>ISBN</th>
                <th>TITLE</th>
                <th>DESCRIPTION</th>
            </tr>
            <%if(books != null) {
            	for(Book book:books) { %>
                <tr>
                    <td><%=book.getIsbn() %></td>
                    <td><%=book.getTitle() %></td>
                    <td><%=book.getDescr() %></td>
                </tr>
            <%}
            	}%>
        </table>
    </div>
</body>
</html>