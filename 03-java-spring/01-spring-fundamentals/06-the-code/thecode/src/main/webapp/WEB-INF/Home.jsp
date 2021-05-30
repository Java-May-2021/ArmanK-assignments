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
 	${errors}
	<h2>What is the code</h2>
	
	<form action="/code" method="POST">
		<input type="text" name="code" placeholder="Enter the code"/>
		<button type="submit">Try Code</button>
		
	</form>

</body>
</html>