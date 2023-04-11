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
<div class="container col-4">
			<h1>Edit an Expense</h1>
			<form:form class="form" action="/expenses/${travel.id}" method="post" modelAttribute="travel">
			<input type="hidden" name="_method" value="put">
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
</body>
</html>