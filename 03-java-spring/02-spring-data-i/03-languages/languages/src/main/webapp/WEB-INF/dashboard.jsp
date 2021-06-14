<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <link rel="stylesheet" 
    	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" 
    	integrity="undefined" 
    	crossorigin="anonymous">
</head>
<body>
 <table class=" col-md-6 my-2 table table-striped">
 	<thead>
 		<tr>
 			<th>Name</th>
 			<th>Creator</th>
 			<th>Version</th>
 			<th>Action</th>
 		</tr>
 	</thead>
 	<tbody>
 		<c:forEach items="${allLanguages}" var="language">
 			<tr>
 				<td>${language.name}</td>
 				<td>${language.creator}</td>
 				<td>${language.version}</td>
 				<td colspan="2">
 					<a href="/languages/edit/${language.id}">Edit</a>|
 					<a href="/languages/delete/${language.id}">Delete</a>
 				</td>
 			</tr>
 		</c:forEach>
 	</tbody>
 </table>
 <div class="row my-2">
			<div class="col-md-6">
				<form:form action="/languages" method="POST" modelAttribute="language">
				    <div class="row mb-3">
				        <form:errors path="name" class="text-danger"/>
				        <form:label path="name" class="col-2 col-form-label">Name</form:label>
				        <div class="col-10">
				        	<form:input path="name" class="form-control"/>
				        </div>
				    </div>
				    <div class="row mb-3">
				        <form:errors path="creator" class="text-danger"/>
				        <form:label path="creator" class="col-2 col-form-label">Creator</form:label>
				        <div class="col-10">
				        	<form:input path="creator" class="form-control"/>
				        </div>
				    </div>
				    <div class="row mb-3">
				        <form:errors path="version" class="text-danger"/>
				        <form:label path="version" class="col-2 col-form-label">Version</form:label>
				        <div class="col-10">
				        	<form:input path="version" class="form-control"/>
				        </div>
				    </div>
				    <div class="text-end">
				    	<input type="submit" class="btn btn-primary" value="Submit"/>
				    </div>
				</form:form> 
			</div>
		</div>
		
</body>
</html>