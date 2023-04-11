<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Burger Tracker</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<header>
	<div class="container">
		<h1>Burger Tracker</h1>
	</div>
	</header>
	<main>
		<table class="table table-striped">
			<thead>
				<th>Burger Name</th>
				<th>Restaurant Name</th>
				<th>Rating (out of 5)</th>
			</thead>
			<tbody>
				<c:forEach var="burger" items="${allBurgers}">
					<tr>
						<td> <a href=""><c:out value="${burger.burgerName}"/></a> </td>
						<td><c:out value="${burger.restaurantName}"/></td>
						<td><c:out value="${burger.rating}"/></td>
						<td><a href="/burgers/${burger.id}/edit"><button>Edit</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container col-4">
			<h1>Add a Burger</h1>
			<form:form class="form" action="/create" method="post" modelAttribute="burger">
				<div class="form-group">
					<form:label path="burgerName">Burger Name</form:label>
					<form:input class="form-control" path="burgerName"/>
					<form:errors path="burgerName" class="text-danger"/>
				</div>
				<div class="form-group">
					<form:label path="restaurantName">Restaurant Name</form:label>
					<form:input class="form-control" path="restaurantName"/>
					<form:errors path="restaurantName" class="text-danger"/>
				</div>
				<div class="form-group">
					<form:label path="rating">Rating</form:label>
					<form:input class="form-control" path="rating"/>
					<form:errors path="rating" class="text-danger"/>
				</div>
				<div class="form-group">
					<form:label path="notes">Notes</form:label>
					<form:input class="form-control" path="notes"/>
					<form:errors path="notes" class="notes"/>
				</div>
				<button class="btn btn-primary">Submit</button>
			</form:form>
		</div>
	</main>
</body>
</html>