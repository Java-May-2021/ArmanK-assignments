<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<form method="POST" action="/result">
	 
		  <label class="label">Your Name:</label>
		  <div class="control">
		    <input class="input" name="name" type="text" placeholder="e.g Arman">
		  </div>
		  <br>

		 <label class="label">Dojo Location</label>
		  <select name="location">
		    <option value="dallas">Dallas</option>
		    <option value="sanjose">San Jose</option>
		    <option value="california">California</option>
		  </select>
		  <br>
		
		  <label class="label">Favorite Language</label>
		  <select name="language">
		    <option value="python">Python</option>
		    <option value="java">Java</option>
		    <option value="c++">C++</option>
		  </select>
		  <br>
		<textarea class="textarea is-primary" name="comment"></textarea>
	
		<button type="submit">Button</button>
	</form>
</body>
</html>