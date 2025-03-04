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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<head>
		<h1>Friends</h1>
	</head>

	<main>
		<h2>My Friend List</h2>
	<ul>
		<c:forEach var="i" items="${viewFriends}">
			<li>
				<ul>
					<li>${i.favColor}</li>
					<li><a href="${i.linkedIn}">LinkedIn</a></li>
				</ul>
			</li>
		</c:forEach>
	</ul>
	</main>

</body>
</html>