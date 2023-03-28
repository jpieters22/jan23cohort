<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<header>
		<h1>Send an Omikuji!</h1>
	</header>
	<main>
		<form action="/show" method="post">
			<label>Pick any number from 5 to 25</label><br>
			<input type="number" id="number" name="fortuneNumber" min="5" max="25"><br>
			<label>Enter the name of any city</label><br>
			<input type="text" name="city"><br>
			<label>Enter the name of any real person</label><br>
			<input type="text" name="name"><br>
			<label>Enter professional endeavor or hobby</label><br>
			<input type="text" name="hobby"><br>
			<label>Enter any type of living thing</label><br>
			<input type="text" name="living"><br>
			<label>Say something nice to someone</label><br>
			<textarea rows="10" cols="30" name="comment"></textarea><br>
			<p>Send and show a friend</p><br>
			<input type="submit" value="Send">
		</form>
	</main>

</body>
</html>