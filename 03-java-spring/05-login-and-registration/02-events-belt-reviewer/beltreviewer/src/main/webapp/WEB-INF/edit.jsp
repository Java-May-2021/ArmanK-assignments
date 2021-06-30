<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Edit Event</title>
</head>
<body>
<div class="container">
  <div class="text-right">
    <a class="btn btn-primary" href="/events">Go Back</a>
  </div>
	
    <h2>Edit: ${event.name} </h2>

             <form:form method="POST" action="/events/edit/${event.id}" modelAttribute="event">
                 
                 <div class="form-group col-7">
                     <form:label path="name">Name</form:label>
                     <form:errors path="name"></form:errors>
                     <form:input class="form-control" path="name"/>
                 </div>
                 <div class="form-group col-7">
                     <form:label path="Date">Date</form:label>
                     <form:errors path="date"></form:errors>
                     <form:input class="form-control" type="date" path="date"/>
                 </div>
                 <div class="form-group col-7">
                     <form:label path="location">Location</form:label>
                     <form:errors path="location"></form:errors>
                     <form:input class="form-control" path="location"/>
                 </div>
                      <form:select path="state">
			            	<form:option value="CA">CA</form:option>
							<form:option value="TX">TX</form:option>
							<form:option value="NY">NY</form:option>
							<form:option value="SA">SA</form:option>
							<form:option value="KA">KA</form:option>
	           			</form:select>
	           		 <form:errors path="state"></form:errors>
		        <button class="btn-btn-dark">Update event!</button>
             </form:form>
</div>
</body>
</html>