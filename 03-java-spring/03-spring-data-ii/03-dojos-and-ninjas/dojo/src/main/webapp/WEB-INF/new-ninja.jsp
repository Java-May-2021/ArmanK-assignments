<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
</head>
<body>
	<h2>New Ninja</h2>
	<form:form method="post" action="/ninjas/new" modelAttribute="ninja">
		<form:label path="dojo">Dojo</form:label>
		<form:select path="dojo">
			 <c:forEach items="${allDojo}" var="d">
			        	<form:option value="${ d.id }">${ d.name }</form:option>
			 </c:forEach>
		 </form:select>
		 <br /><br />
		<form:label path="first_name">First name</form:label>
		<form:input path="first_name" /><br /><br />
		<form:label path="last_name">Last Name</form:label>
		<form:input path="last_name" /> <br /><br />
		<form:label path="age">Age</form:label>
		<form:input path="age" value=" "/> <br /><br />
		<button type="submit">Create</button>
	</form:form>
</body>
</html>