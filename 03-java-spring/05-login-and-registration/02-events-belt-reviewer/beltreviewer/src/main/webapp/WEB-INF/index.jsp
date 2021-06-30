<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Authentication</title>
</head>
<body>
	<div class="container">
	<div class="row">
		<h2>Welcome</h2>
		<p>${logout}</p>
		<div class="col-md-6">
		 <h4 class="my-4">Register</h4>
		 <p><form:errors path="user.*"/></p>
			<form:form action="/register" method="POST" modelAttribute="user">
					<div class="form-group">
						<form:label path="f_name">First Name</form:label>
						<form:input path="f_name" type="text" class="form-control" />
					</div>
					
					<div class="form-group">
						<form:label path="l_name">Last Name</form:label>
						<form:input path="l_name" type="text" class="form-control" />
					</div>
					
					<div class="form-group">
						<form:label path="email">Email</form:label>
						<form:input path="email" type="email" class="form-control" />
					</div>
					
					<div class="form-group">
						<form:label path="location">Location</form:label>
						
						<form:input path="location" type="text" class="form-control" />
						
						<form:select path="state" class="my-2">
							<form:option value="CA">CA</form:option>
							<form:option value="TX">TX</form:option>
							<form:option value="NY">NY</form:option>
							<form:option value="SA">SA</form:option>
							<form:option value="KA">KA</form:option>
						</form:select>
					</div>
					
					<div class="form-group">
						<form:label path="password">Password</form:label>
						<form:input path="password" type="password" class="form-control" />
					</div>
					
					<div class="form-group">
						<form:label path="confirm_pw">Confrim Password</form:label>
						<form:input path="confirm_pw" type="password" class="form-control" />
					</div>
					
					<form:button class="my-2 btn btn-success">Register</form:button>
			 </form:form>
		</div>
		
		<div class="col-md-5">
		 <h4 class="my-4">Login</h4>
			<form method="POST" action="/login">
				<div>${error}</div>
				<label>Email: </label>
				<input type="email" name="email" class="form-control" />
				
				<label>Password: </label>
				<input type="password" name="password" class="form-control" />
			
				<button type="submit" class="btn btn-success my-2">Login</button>
			</form>
		</div>
		</div>
	</div>
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>