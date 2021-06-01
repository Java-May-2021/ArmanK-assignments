<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1px">
		<thead>
		
				<tr>
					<th>Title</th>
					<th>Description</th>
					<th>Language</th>
					<th>Number of Pages</th>
				</tr>	
		</thead>
		<tbody>
			<c:forEach items="${books}" var="book">
				<tr>
					<td><a href="/books/${book.id}">${book.title}</a></td>
					<td>${book.description}</td>
					<td>${book.language}</td>
					<td>${book.numberOfPages}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/books/new">Create New Book</a>
</body>
</html>