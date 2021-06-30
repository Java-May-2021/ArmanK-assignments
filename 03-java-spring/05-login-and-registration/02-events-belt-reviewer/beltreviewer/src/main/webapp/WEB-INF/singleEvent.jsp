<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
  <h2><c:out value="${event.name}" /></h2>
  <h4 class="mt-2">Host: ${event.host.f_name}</h4>
  <h4>Date: <fmt:formatDate type = "date" 
         value = "${event.date}" />
  </h4>
  <h4>Location: ${event.location}, ${event.state}</h4>
  <h4>People who are attending this event: ${event.participators.size()}</h4>
  <div class="col-md-5">
   <table class="table table-striped table-bordered ">
  	<thead>
  		<tr>
  			<td>Name</td>
  			<td>Location</td>
  		</tr>
  	</thead>
  	<tbody>
  		<c:forEach items="${event.participators}" var="participator">
  			<tr>
  				<td>${participator.f_name} ${participator.l_name}</td>
  				<td>${participator.location}</td>
  			</tr>
  		</c:forEach>
  	</tbody>
  </table>
  </div>
 
</body>
</html>