<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@  taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
 <div class="container">
 	<h3>Here are some events in your state</h3>
 	<table class="table table-bordered table-dark">
		  <thead>
		    <tr>
		      <th scope="col">Name</th>
		      <th scope="col">Date</th>
		      <th scope="col">Location</th>
		      <th scope="col">Host</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${userEvents}" var="userEvent">
			  	<tr>
			      <td><a href="/events/${userEvent.id}">${userEvent.name }</a>/</td>
			      <td><fmt:formatDate type = "date" dateStyle = "long"  value = "${userEvent.date}" /></td>
			      <td>${userEvent.location}</td>
			      <td>${userEvent.host.f_name}</td>
			      <td>
			      	<c:choose>
			      		<c:when test="${userEvent.host.id == user.id}">
			      			<a href="/events/edit/${userEvent.id}">Edit |</a>
			      			<a href="/events/delete/${userEvent.id}">Delete</a>
			      		</c:when>
			      		<c:otherwise>
			      			<c:choose>
			      				<c:when test="${userEvent.participators.contains(user)}">
			      					<a href="/events/unjoin/${userEvent.id}">Cancel</a>
			      				</c:when>
			      				<c:otherwise>
			      					<a href="/events/join/${userEvent.id}">Join</a>
			      				</c:otherwise>
			      			</c:choose>
			      		</c:otherwise>
			      	</c:choose>
			      </td>
			    </tr>
		  	</c:forEach>
		  </tbody>
		</table>
		
			<h3 class="my-3">Here are some others events not in your  state</h3>
		 	<table class="table table-bordered table-dark">
		  <thead>
		    <tr>
		      <th scope="col">Name</th>
		      <th scope="col">Date</th>
		      <th scope="col">Location</th>
		      <th scope="col">Host</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${otherEvents}" var="otherEvent">
			  	<tr>
			      <td><a href="/events/${otherEvent.id}">${otherEvent.name }</a></td>
			      <td><fmt:formatDate type = "date" dateStyle = "long"  value = "${otherEvent.date}" /></td>
			      <td>${otherEvent.location}</td>
			      <td>${otherEvent.host.f_name}</td>
			      <td>
			      	<c:choose>
			      		<c:when test="${otherEvent.host.id == user.id}">
			      			<a href="/events/edit/${otherEvent.id}">Edit |</a>
			      			<a href="/events/delete/${otherEvent.id}">Delete</a>
			      		</c:when>
			      		<c:otherwise>
			      			<c:choose>
			      				<c:when test="${otherEvent.participators.contains(user)}">
			      					<a href="/events/unjoin/${otherEvent.id}">Cancel</a>
			      				</c:when>
			      				<c:otherwise>
			      					<a href="/events/join/${otherEvent.id}">Join</a>
			      				</c:otherwise>
			      			</c:choose>
			      		</c:otherwise>
			      	</c:choose>
			      </td>
			    </tr>
		  	</c:forEach>
		  </tbody>
		</table>
   <div class="col-md-6">
 	<h3>Create a Event</h3>
    <p>
 			<form:errors path="event.*" />
    </p>
 
 	<form:form method="POST" action="/events/create" modelAttribute="event">
 		<form:label path="name">Name</form:label>
 		<form:input path="name" type="text" class="form-control"/>
 		
 		<form:label path="date">Date</form:label>
 		<form:input path="date" type="date" class="form-control" />
 		
 		<form:label path="location">Location</form:label>
 		<form:input path="location" type="text" class="form-control"/>
 		
 		<form:select path="state" class="my-2">
							<form:option value="CA">CA</form:option>
							<form:option value="TX">TX</form:option>
							<form:option value="NY">NY</form:option>
							<form:option value="SA">SA</form:option>
							<form:option value="KA">KA</form:option>
		</form:select><br />
 		
 		<form:button class="btn btn-success">Submit</form:button>
 	</form:form>
   </div>
 </div>
 
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
 
</body>
</html>