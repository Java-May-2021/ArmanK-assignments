<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
</head>
<body>
	<h2>New Dojo</h2>
	<form:form method="post" action="/dojos/new" modelAttribute="dojo">
		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<button type="submit">Create</button>
	</form:form>
</body>
</html>