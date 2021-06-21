
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
	<h2>New Product</h2>
	<form:form method="post" action="/products/new" modelAttribute="product">
		<form:label path="name">Name</form:label>
		<form:input path="name" /> <br />
		<br />
		<form:label path="description">Description</form:label>
		<form:input path="description" /> <br /><br />

		<form:label path="price">Price</form:label>
		<form:input path="price" /> <br /> <br />
				
		<button type="submit">Create</button>
	</form:form>
</body>
</html>