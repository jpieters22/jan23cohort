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
<title>Login and Registration</title>
</head>
<body>
<header>
<h1>Welcome!</h1>
<h2>Join our growing community!</h2>
</header>
	<main>
	<div class="forms">
			<form:form action="/register" method="POST" modelAttribute="newUser">
				<section>
					<form:label class="form-label" path="firstName">First Name</form:label>
					<form:input type="text" class="form-control form-control-lg" path="firstName" />
					<form:errors path="firstName" class="text-danger" />
				</section>
				<section>
					<form:label class="form-label" path="lastName">Last Name</form:label>
					<form:input type="text" class="form-control form-control-lg" path="lastName" />
					<form:errors path="lastName" class="text-danger" />
				</section>
				<section>
					<form:label class="form-label" path="email">Email</form:label>
					<form:input type="email" class="form-control form-control-lg" path="email" />
					<form:errors path="email" class="text-danger" />
				</section>
				<section>
					<form:label class="form-label" path="password">Password</form:label>
					<form:input type="password" class="form-control form-control-lg" path="password" />
					<form:errors path="password" class="text-danger" />
				</section>
				<section>
					<form:label class="form-label" path="confirmPassword">Confirm Password</form:label>
					<form:input type="password" class="form-control form-control-lg" path="confirmPassword" />
					<form:errors path="confirmPassword" class="text-danger" />
				</section>
				<button class="btn btn-primary">Register and Login</button>
			</form:form>
			<form:form action="/login" method="POST" modelAttribute="newLogin">
				<section>
					<form:label class="form-label" path="email">Email</form:label>
					<form:input type="email" class="form-control form-control-lg" path="email" />
					<form:errors path="email" class="text-danger" />
				</section>
				<section>
					<form:label class="form-label" path="password">Password</form:label>
					<form:input type="password" class="form-control form-control-lg" path="password" />
					<form:errors path="password" class="text-danger" />
				</section>
				<button class="btn btn-primary">Login</button>
			</form:form>
		</div>
	</main>
</body>
</html>