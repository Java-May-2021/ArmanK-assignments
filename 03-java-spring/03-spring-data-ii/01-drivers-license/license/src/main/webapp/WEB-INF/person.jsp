<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h2>${person.first_name } ${person.last_name}</h2>
  <br/> <br />
  <p>License Number ${person.license.id}</p>
  <p>State ${person.license.state }</p>
  <p>Expiration Date ${person.license.expiration_date}</p>
</body>
</html>