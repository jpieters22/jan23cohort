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
<title>Insert title here</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<header>
	<div class="container">
		<h1>Safe Travels</h1>
	</div>
	</header>
	<main>
		<table class="table table-striped">
			<thead>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
			</thead>
			<tbody>
				<c:forEach var="travel" items="${allTravel}">
					<tr>
						<td> <a href="/expenses/${travel.id}/show"><c:out value="${travel.expense}"/></a> </td>
						<td><c:out value="${travel.vendor}"/></td>
						<td><c:out value="${travel.amount}"/></td>
						<td><a href="/expenses/${travel.id}/edit"><button>Edit</button></a></td>
						<td> <a href="/expenses/${travel.id}/delete"><button>Delete</button></a> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container col-4">
			<h1>Add an Expense</h1>
			<form:form class="form" action="/create" method="post" modelAttribute="travel">
				<div class="form-group">
					<form:label path="expense">Expense Name</form:label>
					<form:input class="form-control" path="expense"/>
					<form:errors path="expense" class="text-danger"/>
				</div>
				<div class="form-group">
					<form:label path="vendor">Vendor</form:label>
					<form:input class="form-control" path="vendor"/>
					<form:errors path="vendor" class="text-danger"/>
				</div>
				<div class="form-group">
					<form:label path="amount">Amount</form:label>
					<form:input class="form-control" path="amount"/>
					<form:errors path="amount" class="text-danger"/>
				</div>
				<div class="form-group">
					<form:label path="description">Description</form:label>
					<form:input class="form-control" path="description"/>
					<form:errors path="description" class="notes"/>
				</div>
				<button class="btn btn-primary">Submit</button>
			</form:form>
		</div>
	</main>
</body>
</html>