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
		<h1>Hello</h1>
		<h4><c: out value="${session}"/></h4>
	</header>

	<main>
		<h2>Pet Name: <c: out value="${petName}"/></h2>
		<h2>Pet Age: <c: out value="${petAge}"/></h2>
	
	<form action="/submit" method="post">
		

	</form>
	</main>

</body>
</html>