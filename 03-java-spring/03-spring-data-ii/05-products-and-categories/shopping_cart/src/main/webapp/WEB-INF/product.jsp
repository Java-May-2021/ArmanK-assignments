
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Category</title>
</head>
<body>
	<h2>${product.name}</h2>
	<div>
		<h4>Categories:</h4>

		<c:forEach items="${product.categories}" var="c">
			<p>-${c.name}</p>
		</c:forEach>
	</div>
	
	<div>
		<p>Add Category</p>
		<form method="post" action="/products/${product.id}">
				<label>Categories:</label>
				<select name="categories">
					<c:forEach items="${categories}" var="cat">
						<c:choose>
							<c:when test="${!cat.products.contains(prod)}">
								<option value="${cat.id}"> ${cat.name} </option>
							</c:when>
						</c:choose>
					</c:forEach>
				</select>
				<hr>
				<button class="btn btn-success">Add</button>
			</form>

	</div>
	
</body>
</html>