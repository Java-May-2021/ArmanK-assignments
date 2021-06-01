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
	<h2>${book.title}</h2>
	<p>Description: ${book.description}</p>
	<p>Number of pages: ${book.numberOfPages}</p>
	<a href="#">Edit Book</a><br>
	<a href="#">Delete</a>
</body>
</html>