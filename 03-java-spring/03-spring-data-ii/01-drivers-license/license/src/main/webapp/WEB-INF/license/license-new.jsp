<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>New License</h2>
	<form:form method="post" action="/license/new"	modelAttribute="license">
		 <form:label path="person">Person</form:label>
		 <form:select path="person" items="${personList}" /><br/>
	
		<form:label path="state">State</form:label>
		<form:input path="state" />
		
		<form:label path="expiration_date">Expiration date</form:label>
		<form:input path="expiration_date" />
		
		<button type="submit">Create</button>
	</form:form>
</body>
</html>