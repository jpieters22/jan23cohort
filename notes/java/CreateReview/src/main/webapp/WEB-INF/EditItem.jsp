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
		<form:form action="/item/${item.id}/update" method="post" modelAttribute="">
			<label for="name">Name</label>
			<input type="text" name="name" id="" value="${item.name}"/>
			<form:errors path="name" class="text-warning"></form:errors>
			<form:label path="price">Price</form:label>
			<form:input path="price" type="number" value="${item.price}"/>
			<form:errors path="price" class="text-warning"></form:errors>
			
			<button>Edit Item</button>
		</form:form>
	</main>
	
	
</body>
</html>