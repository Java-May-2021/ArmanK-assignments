<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
  	
  </style>
<title>Create person</title>
</head>
<body>
	<form:form action="/create" method="post" modelAttribute="person">
		<form:label path="first_name">First name:</form:label>
		<form:input path="first_name" />
		<br />
			<br />
		<form:label path="last_name">Last name:</form:label>
		<form:input path="last_name" />
		<br />
			<br />
		<form:button>Create</form:button>
	</form:form>
</body>
</html>