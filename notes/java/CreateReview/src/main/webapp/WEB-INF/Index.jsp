<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- for forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- for validation -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<header>
		<h1>Hello</h1>
		<nav>
			<a href="/">Home</a>
			<a href="/addItem">Add Item</a>
		</nav>
	</header>

	<main>
		<c:forEach items="${allItems}" var="i">
			<p>${i.name} - <a href="/item${i.id}/edit">Edit</a></p>
		</c:forEach>
	</main>

</body>
</html>