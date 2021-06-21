
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Category</title>
</head>
<body>
	<h2>New Category</h2>
	<form:form method="post" action="/categories/new" modelAttribute="category">
		<form:label path="name">Name</form:label>s
		<form:input path="name" /> <br />
	
				
		<button type="submit">Create</button>
	</form:form>
</body>
</html>