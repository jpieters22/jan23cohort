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
<!-- Bootstrap CSS -->
<!-- <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"> -->
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<!-- My CSS -->
<link rel='stylesheet' href='/styles.css'>
<script type = "text/javascript" src='/js/scripts.js'></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container my-5">
        <h1 class="display-2 text-primary">Book Club</h1>
        <p class="fs-5">A place for friends to share thoughts on books</p>
		<div class="row">
			<div class="col-6">
				<h2 class="display-3">Register</h2>
				<form:form action="/register" method="post" modelAttribute="newUser">
				<div class="mt-3">
					<form:label path="firstName" class="form-label">First Name:</form:label>
					<form:input path="firstName" class="form-control"/>
					<form:errors path="firstName" class="text-danger"/>
				</div>
				<div class="mt-3">
					<form:label path="lastName" class="form-label">Last Name:</form:label>
					<form:input path="lastName" class="form-control"/>
					<form:errors path="lastName" class="text-danger"/>
				</div>
				<div class="mt-3">
					<form:label path="email" class="form-label">Email:</form:label>
					<form:input type="email" path="email" class="form-control"/>
					<form:errors path="email" class="text-danger"/>
				</div>
				<div class="mt-3">
					<form:label path="password" class="form-label">Password:</form:label>
					<form:input type="password" path="password" class="form-control"/>
					<form:errors path="password" class="text-danger"/>
				</div>
				<div class="mt-3">
					<form:label path="confirmPassword" class="form-label">Confirm Password:</form:label>
					<form:input type="password" path="confirmPassword" class="form-control"/>
					<form:errors path="confirmPassword" class="text-danger"/>
				</div>
				<button class="btn btn-success btn-lg mt-3 float-end">Register</button>
			</form:form>
			</div>
			<div class="col-6">
				<h2 class="display-3">Login</h2>
				<form:form action="/login" method="post" modelAttribute="newLogin">
				<div class="mt-3">
					<form:label path="email" class="form-label">Email:</form:label>
					<form:input type="email" path="email" class="form-control"/>
					<form:errors path="email" class="text-danger"/>
				</div>
				<div class="mt-3">
					<form:label path="password" class="form-label">Password:</form:label>
					<form:input type="password" path="password" class="form-control"/>
					<form:errors path="password" class="text-danger"/>
				</div>
				<button class="btn btn-primary btn-lg mt-3 float-end">Login</button>
			</form:form>
			</div>
		</div>
	</div>
</body>
</html>