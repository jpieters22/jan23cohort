<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WOS Mart</title>
</head>
<body>
	<header>
		<h1>Welcome to WOS Mart</h1>
	</header>

	<main>
		<h2><c:out value="${name}"/></h2>
		<h2><c:out value="${pet}"/></h2>
		<form action="/updateSession" method="post">
			<label for="name">Name</label>
			<input type="text" name="name" id=""/>
			<label for="pet">Pet Name</label>
			<input type="text" name="pet" id=""/>
			<button>Change Session Value</button>
		</form>
	</main>




</body>
</html>