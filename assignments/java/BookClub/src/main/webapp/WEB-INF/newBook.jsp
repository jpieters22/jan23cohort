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
<title>Add a new Book</title>
</head>
<body>
	<div class="container my-5 fs-5">
        <div class="d-flex justify-content-between align-items-center">
            <h2 class="display-3">Add a Book to your Shelf!</h2>
            <a href="/books">back to dashboard</a>
        </div>
        <form:form action="/books/add" method="post" modelAttribute="book" class="col-8">
				<div class="mt-3">
					<form:label path="title" class="form-label">Title:</form:label>
					<form:input path="title" class="form-control"/>
					<form:errors path="title" class="text-danger"/>
				</div>
				<div class="mt-3">
					<form:label path="author" class="form-label">Author:</form:label>
					<form:input path="author" class="form-control"/>
					<form:errors path="author" class="text-danger"/>
				</div>
				<div class="mt-3">
					<form:label path="thoughts" class="form-label">My Thoughts:</form:label>
                    <form:textarea type="text" path="thoughts" class="form-control" rows="3"></form:textarea>
					<form:errors path="thoughts" class="text-danger"/>
				</div>
                <button class="btn btn-primary mt-4 btn-lg float-end">Add Book</button>
        </form:form>
	</div>
</body>
</html>