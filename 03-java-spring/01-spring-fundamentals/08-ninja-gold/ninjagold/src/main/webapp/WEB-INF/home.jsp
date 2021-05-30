<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NinjaGold</title>
<style>
	.green{
		color:green;
	}
	.red{
		color:red;
	}
</style>
</head>
<body>
	<div>
		<h2>Your Gold</h2>
		<div>${gold}</div>
	</div>

		<div class="card">
		<form method="POST" action="/gold">
			<h2>Farm</h2>
			<p>(earns 10-20 gold)</p>
			<input type="hidden" value="farm" name="building"/>
			<button type="submit">Find Gold!</button>
		</form>
	</div>
		<div class="card">
		<form method="POST" action="/gold">
			<h2>Cave</h2>
			<p>(earns 5-10 gold)</p>
			<input type="hidden" value="cave" name="building"/>
			<button type="submit">Find Gold!</button>
		</form>
	</div>
		<div class="card">
		<form method="POST" action="/gold">
			<h2>House</h2>
			<p>(earns 2-5 gold)</p>
			<input type="hidden" value="house" name="building"/>
			<button type="submit">Find Gold!</button>
		</form>
			<div class="card">
		<form method="POST" action="/gold">
			<h2>Casino</h2>
			<p>(earns/takes 0-50 gold)</p>
			<input type="hidden" value="casino" name="building"/>
			<button type="submit">Find Gold!</button>
		</form>
	</div>
	<c:forEach items="${activity}" var="act">
		<p class='${act.contains("ouch")?"red":"green"}'>${act}</p>
	</c:forEach>
	</div>
</body>
</html>