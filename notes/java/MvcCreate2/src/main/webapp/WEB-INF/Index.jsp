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
	</header>

	<main>
	<form:form action="/createImg" method="post" modelAttribute="image">
		<section>
			<label for="name">Image Name</label>
			<input type="text" name="name">
			<form:errors path="name"></form:errors>
		</section>
		<section>
			<label for="url">Image Link</label>
			<input type="text" name="url">
			<form:errors path="url"></form:errors>
		</section>
		<section>
			<label for="category">Image Name</label>
			<input type="text" name="category">
			<form:errors path="category"></form:errors>
		</section>
		<button>Add Image</button>
	</form:form>
		<c:forEach var="i" items="${viewImages}">
			<div>
				<h3>${i.name}</h3>
				<img src="${i.url}" alt="${i.name}" />
				<h3>Category ${i.category}</h3>      
			</div>
		</c:forEach>
	</main>

	<footer>
	
	</footer>

</body>
</html>